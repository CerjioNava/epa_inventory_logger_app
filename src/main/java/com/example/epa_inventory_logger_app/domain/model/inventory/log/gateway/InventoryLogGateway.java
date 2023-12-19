package com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryLogGateway {

    Flux<InventoryLog> getAllInventoryLogs(Pageable pageable);
    Flux<InventoryLog> getAllInventoryLogsByArticleId(String articleId);
    Mono<InventoryLog> saveInventoryLog(InventoryLog inventoryLog);

}
