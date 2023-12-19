package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.error;

import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.inventory.error.data.InventoryErrorData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface InventoryErrorRepository extends ReactiveMongoRepository<InventoryErrorData, String> {
    Flux<InventoryErrorData> findAllBy(Pageable pageable);
}
