package com.example.epa_inventory_logger_app.domain.usecase.inventory.log;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway.InventoryLogGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllInventoryLogsByArticleIdLogsUseCase implements Function<String, Flux<InventoryLog>> {

    private final InventoryLogGateway inventoryLogGateway;

    @Override
    public Flux<InventoryLog> apply(String articleId) {
        System.out.println("INFO: Request to get all inventory logs by articleId: "+articleId);
        return inventoryLogGateway.getAllInventoryLogsByArticleId(articleId);
    }
}
