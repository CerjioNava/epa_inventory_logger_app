package com.example.epa_inventory_logger_app.domain.model.sale.error;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleError {

    private String error;
    private Date date;
    private Object object;

}
