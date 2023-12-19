package com.example.epa_inventory_logger_app.domain.model.sale.log;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleLog {

    private String message;
    private Date date;
    private Object object;

}
