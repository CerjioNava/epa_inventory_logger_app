package com.example.epa_inventory_logger_app.domain.usecase.inventory.error;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import com.example.epa_inventory_logger_app.domain.model.inventory.error.gateway.InventoryErrorGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class SaveInventoryErrorUseCase implements Function<InventoryError, Mono<InventoryError>> {

    private final InventoryErrorGateway inventoryErrorGateway;

    @Override
    public Mono<InventoryError> apply(InventoryError inventoryError) {
        System.out.println("INFO: Request to save Inventory Error: "+inventoryError);
        return inventoryErrorGateway.saveInventoryError(inventoryError);
    }
}
