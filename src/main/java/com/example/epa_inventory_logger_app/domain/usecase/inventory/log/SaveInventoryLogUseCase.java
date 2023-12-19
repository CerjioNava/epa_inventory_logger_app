package com.example.epa_inventory_logger_app.domain.usecase.inventory.log;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway.InventoryLogGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class SaveInventoryLogUseCase implements Function<InventoryLog, Mono<InventoryLog>> {

    private final InventoryLogGateway inventoryGateway;

    @Override
    public Mono<InventoryLog> apply(InventoryLog inventoryLog) {
        System.out.println("INFO: Request to save Inventory Log: "+inventoryLog);
        return inventoryGateway.saveInventoryLog(inventoryLog);
    }
}
