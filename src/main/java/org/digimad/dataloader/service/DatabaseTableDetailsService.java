package org.digimad.dataloader.service;

import org.digimad.dataloader.dto.DataLoadRequest;
import org.digimad.dataloader.util.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseTableDetailsService {

    private final JdbcTemplate jdbcTemplate;
    private final QueryBuilder queryBuilder;

    @Autowired
    public DatabaseTableDetailsService(JdbcTemplate jdbcTemplate, QueryBuilder queryBuilder) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryBuilder = queryBuilder;
    }

//    public List<String> getAllTableNames() {
//        return jdbcTemplate.queryForList("SHOW TABLES", String.class);
//    }

    public List<Map<String, Object>> getTableDetails(String tableName) {
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    public List<Map<String, Object>> getTableDetails(DataLoadRequest request) {
        String sql = queryBuilder.generateQuery(request);
        return jdbcTemplate.queryForList(sql);
    }

    public List<String> getAllTableNames() {
        List<String> tableNames = new ArrayList<>();
        try {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            ResultSet resultSet = metaData.getTables(null, "PUBLIC", null, new String[]{"TABLE"});

            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                // Check if the table is not a system table
//                if (!isSystemTable(resultSet)) {
//                    tableNames.add(tableName);
//                }
                tableNames.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return tableNames;
    }

    private boolean isSystemTable(ResultSet resultSet) throws SQLException {
        // You may need to customize this condition based on your database
        String tableType = resultSet.getString("TABLE_TYPE");
//        return tableType != null && tableType.equalsIgnoreCase("SYSTEM TABLE");
        return tableType != null && tableType.equalsIgnoreCase("BASE TABLE");
    }

    public List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        try {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, tableName, null);

            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                columnNames.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return columnNames;
    }
}
