package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.error.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "SaleError")
public class SaleErrorData {

    @Id
    private String id;
    private String error;
    private Date date;
    private Object object;

}
