package com.example.epa_inventory_logger_app.domain.usecase.inventory.log;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway.InventoryLogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllInventoryLogsUseCase implements Function<Pageable, Flux<InventoryLog>> {

    private final InventoryLogGateway inventoryLogGateway;

    @Override
    public Flux<InventoryLog> apply(Pageable pageable) {
        System.out.println("INFO: Request to get all inventory logs by pagination " +
                "(Page: "+pageable.getPageNumber()+", Size: "+pageable.getPageSize()+")");
        return inventoryLogGateway.getAllInventoryLogs(pageable);
    }
}
