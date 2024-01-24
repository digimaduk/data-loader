package org.digimad.dataloader.controller;

import org.digimad.dataloader.dto.Table;
import org.digimad.dataloader.entities.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataLoader {

//    @GetMapping("/{orderId}/orderitems")
//    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long orderId) {
//        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
//        return new ResponseEntity<>(orderItems, HttpStatus.OK);
//    }

    @GetMapping("/tables")
    public ResponseEntity<List<Table>> getTablesDetails() {
        Table order = new Table();
        order.setName("Order");
        List<String> orderColumns = new ArrayList<>();
        orderColumns.add("orderId");
        orderColumns.add("customerId");
        orderColumns.add("status");
        orderColumns.add("totalAmount");
        order.setColumns(orderColumns);
        Table orderItem = new Table();
        orderItem.setName("OrderItem");
        List<String> orderItemColumns = new ArrayList<>();
        orderItemColumns.add("orderItemId");
        orderItemColumns.add("orderId");
        orderItemColumns.add("productId");
        orderItemColumns.add("quantity");
        orderItemColumns.add("unitPrice");
        orderItemColumns.add("totalPrice");
        orderItem.setColumns(orderItemColumns);
        List<Table> list = new ArrayList<>();
        list.add(order);
        list.add(orderItem);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}