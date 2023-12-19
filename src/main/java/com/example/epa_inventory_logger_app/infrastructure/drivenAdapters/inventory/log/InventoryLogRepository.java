package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.log;

import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.log.data.InventoryLogData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface InventoryLogRepository extends ReactiveMongoRepository<InventoryLogData, String> {
    Flux<InventoryLogData> findAllBy(Pageable pageable);
}
