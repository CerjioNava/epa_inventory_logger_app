package com.example.epa_inventory_logger_app.domain.usecase.sale.log;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class SaveSaleLogUseCase implements Function<SaleLog, Mono<SaleLog>> {

    private final SaleLogGateway saleLogGateway;

    @Override
    public Mono<SaleLog> apply(SaleLog saleLog) {
        System.out.println("INFO: Request to save Sale Log: "+saleLog);
        return saleLogGateway.saveSaleLog(saleLog);
    }
}
