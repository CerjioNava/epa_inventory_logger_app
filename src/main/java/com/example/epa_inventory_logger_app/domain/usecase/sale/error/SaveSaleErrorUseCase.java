package com.example.epa_inventory_logger_app.domain.usecase.sale.error;

import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import com.example.epa_inventory_logger_app.domain.model.sale.error.gateway.SaleErrorGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class SaveSaleErrorUseCase implements Function<SaleError, Mono<SaleError>> {

    private final SaleErrorGateway saleErrorGateway;

    @Override
    public Mono<SaleError> apply(SaleError saleError) {
        System.out.println("INFO: Request to save Sale Error: "+saleError);
        return saleErrorGateway.saveSaleError(saleError);
    }
}
