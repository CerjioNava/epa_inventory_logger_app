package com.example.epa_inventory_logger_app.domain.usecase.sale.log;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetRetailSaleLogsUseCase implements Supplier<Flux<SaleLog>> {

    private final SaleLogGateway saleLogGateway;

    @Override
    public Flux<SaleLog> get() {
        System.out.println("INFO: Request to get all retail sales logs");
        return saleLogGateway.getRetailSaleLogs();
    }
}
