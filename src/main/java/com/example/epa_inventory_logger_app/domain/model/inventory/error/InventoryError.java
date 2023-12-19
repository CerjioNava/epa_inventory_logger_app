package com.example.epa_inventory_logger_app.domain.model.inventory.error;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryError {

    private String error;
    private Date date;
    private Object object;

}
