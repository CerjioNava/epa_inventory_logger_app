package com.example.epa_inventory_logger_app.domain.model.sale.error.gateway;

import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleErrorGateway {

    Flux<SaleError> getAllSaleErrors(Pageable pageable);
    Mono<SaleError> saveSaleError(SaleError saleError);

}
