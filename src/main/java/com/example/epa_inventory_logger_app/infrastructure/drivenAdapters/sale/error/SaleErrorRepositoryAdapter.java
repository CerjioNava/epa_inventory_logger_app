package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.error;

import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import com.example.epa_inventory_logger_app.domain.model.sale.error.gateway.SaleErrorGateway;
import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.error.data.SaleErrorData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SaleErrorRepositoryAdapter implements SaleErrorGateway {

    private final SaleErrorRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Flux<SaleError> getAllSaleErrors(Pageable pageable) {
        return repository
                .findAllBy(pageable)
                .switchIfEmpty(Flux.empty())
                .map(saleErrorData -> mapper.map(saleErrorData, SaleError.class));
    }

    @Override
    public Mono<SaleError> saveSaleError(SaleError saleError) {
        return repository
                .save(mapper.map(saleError, SaleErrorData.class))
                .map(saleErrorData -> mapper.map(saleErrorData, SaleError.class));
    }
}
