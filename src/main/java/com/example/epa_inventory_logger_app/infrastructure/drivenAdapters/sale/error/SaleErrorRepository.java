package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.error;

import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.error.data.SaleErrorData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface SaleErrorRepository extends ReactiveMongoRepository<SaleErrorData, String> {
    Flux<SaleErrorData> findAllBy(Pageable pageable);
}
