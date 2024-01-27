package org.digimad.dataloader.util;

import lombok.extern.slf4j.Slf4j;
import org.digimad.dataloader.dto.DataLoadRequest;
import org.digimad.dataloader.dto.Table;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class QueryBuilder {

    public String generateQuery(DataLoadRequest request) {
        List<Table> tables = request.getTables();
        String sql = null;
        if (!CollectionUtils.isEmpty(tables)) {
            String columns = generateColumns(tables);
            Map<String, String> map = new HashMap<>();
            map.put("customers", "customer_id");//pk
            map.put("orders", "customer_id"); //fk
            map.put("order_items", "order_id"); //fk
            String joins = generateJoins(request.getTables(), map);
            sql = "SELECT " + columns + " FROM " + tables.get(0).getName() + joins + " WHERE customers.created_date BETWEEN ? AND ?";
            log.info(sql);
            return sql;
        }

        sql = "select o0.order_id,c0.customer_id,c0.first_name,c0.last_name from customers c0 join orders o0 on o0.customer_id=c0.customer_id" +
                " where c0.customer_id in(1,2)";
        return sql;
    }

    private String generateJoins(List<Table> tables, Map<String, String> map) {
        return tables.stream()
                .skip(1) // Skip the first table (no need to join with itself)
                .map(table -> " JOIN " + table.getName() + " ON " + table.getName() + "." + map.get(table.getName()) + " = " + tables.get(0).getName() + "." + map.get(tables.get(0).getName()))
                .collect(Collectors.joining(" "));
    }

    private String generateColumns(List<Table> tables) {
        return tables.stream()
                .flatMap(table -> table.getColumns().stream())
                .collect(Collectors.joining(", "));
    }
}
