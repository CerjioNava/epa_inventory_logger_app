package com.example.epa_inventory_logger_app.domain.model.inventory.error.gateway;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryErrorGateway {

    Flux<InventoryError> getAllInventoryErrors(Pageable pageable);
    Mono<InventoryError> saveInventoryError(InventoryError inventoryError);

}
