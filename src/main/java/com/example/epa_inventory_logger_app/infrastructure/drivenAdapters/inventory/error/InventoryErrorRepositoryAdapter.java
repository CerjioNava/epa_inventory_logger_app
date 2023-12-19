package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.error;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import com.example.epa_inventory_logger_app.domain.model.inventory.error.gateway.InventoryErrorGateway;
import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.error.data.InventoryErrorData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class InventoryErrorRepositoryAdapter implements InventoryErrorGateway {

    private final InventoryErrorRepository repository;
    private final ObjectMapper mapper;


    @Override
    public Flux<InventoryError> getAllInventoryErrors(Pageable pageable) {
        return repository
                .findAllBy(pageable)
                .switchIfEmpty(Flux.empty())
                .map(inventoryErrorData -> mapper.map(inventoryErrorData, InventoryError.class));
    }

    @Override
    public Mono<InventoryError> saveInventoryError(InventoryError inventoryError) {
        return repository
                .save(mapper.map(inventoryError, InventoryErrorData.class))
                .map(inventoryErrorData -> mapper.map(inventoryErrorData, InventoryError.class));
    }
}
