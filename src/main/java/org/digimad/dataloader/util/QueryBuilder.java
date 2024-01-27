package org.digimad.dataloader.util;

import org.digimad.dataloader.dto.DataLoadRequest;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

    public String generateQuery(DataLoadRequest dataLoadRequest) {
//        List<Table> tables = dataLoadRequest.getTables();
//        int i = 0;
//        tables.forEach(table -> {
//            String joinTableStr = table.getName() + " t" + i + " join ";
//        });

        String sql = "select o0.order_id,c0.customer_id,c0.first_name,c0.last_name from customers c0 join orders o0 on o0.customer_id=c0.customer_id" +
                " where c0.customer_id in(1,2)";
        return sql;
    }
}
