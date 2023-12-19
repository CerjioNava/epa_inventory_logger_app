package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.log;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway.InventoryLogGateway;
import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.log.data.InventoryLogData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class InventoryLogRepositoryAdapter implements InventoryLogGateway {

    private final InventoryLogRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Flux<InventoryLog> getAllInventoryLogs(Pageable pageable) {
        return repository
                .findAllBy(pageable)
                .switchIfEmpty(Flux.empty())
                .map(inventoryLogData -> mapper.map(inventoryLogData, InventoryLog.class));
    }

    @Override
    public Mono<InventoryLog> saveInventoryLog(InventoryLog inventoryLog) {
        return repository
                .save(mapper.map(inventoryLog, InventoryLogData.class))
                .map(inventoryLogData -> mapper.map(inventoryLogData, InventoryLog.class));
    }
}
