package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.error.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "InventoryError")
public class InventoryErrorData {

    @Id
    private String id;
    private String error;
    private Date date;
    private Object object;

}
