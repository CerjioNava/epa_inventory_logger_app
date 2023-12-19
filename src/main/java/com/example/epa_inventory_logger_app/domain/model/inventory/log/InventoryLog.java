package com.example.epa_inventory_logger_app.domain.model.inventory.log;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryLog {

    private String message;
    private Date date;
    private Object object;

}
