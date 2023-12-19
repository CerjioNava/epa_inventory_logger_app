package com.example.epa_inventory_logger_app.domain.usecase.inventory.error;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import com.example.epa_inventory_logger_app.domain.model.inventory.error.gateway.InventoryErrorGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllInventoryErrorsUseCase implements Function<Pageable, Flux<InventoryError>> {

    private final InventoryErrorGateway inventoryErrorGateway;

    @Override
    public Flux<InventoryError> apply(Pageable pageable) {
        System.out.println("INFO: Request to get all inventory errors by pagination " +
                "(Page: "+pageable.getPageNumber()+", Size: "+pageable.getPageSize()+")");
        return inventoryErrorGateway.getAllInventoryErrors(pageable);
    }
}
