package org.digimad.dataloader.controller;

import lombok.RequiredArgsConstructor;
import org.digimad.dataloader.dto.DataLoadRequest;
import org.digimad.dataloader.dto.Table;
import org.digimad.dataloader.service.DatabaseTableDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class DataLoader {

    private final DatabaseTableDetailsService databaseTableDetailsService;

//    @GetMapping("/{orderId}/orderitems")
//    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long orderId) {
//        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
//        return new ResponseEntity<>(orderItems, HttpStatus.OK);
//    }

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> getAllTables() {
        List<Table> list = new ArrayList<>();
        List<String> allTableNames = databaseTableDetailsService.getAllTableNames();
        allTableNames.forEach(tableName -> {
            List<String> columnNames = databaseTableDetailsService.getColumnNames(tableName);
            Table tName = new Table();
            tName.setName(tableName);
            tName.setColumns(columnNames);
            list.add(tName);
        });
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/tables/{tableName}")
    public List<Map<String, Object>> getTableDetails(@PathVariable String tableName) {
        return databaseTableDetailsService.getTableDetails(tableName);
    }

    @GetMapping("/tables/{tableName}/columns")
    public List<String> getColumnNames(@PathVariable String tableName) {
        return databaseTableDetailsService.getColumnNames(tableName);
    }

    @PostMapping("/tables")
    public List<Map<String, Object>> getTablesData(@RequestBody DataLoadRequest request) {
        return databaseTableDetailsService.getTableDetails(request);
    }

}
