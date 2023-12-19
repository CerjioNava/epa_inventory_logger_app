package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.log;

import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.log.data.SaleLogData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface SaleLogRepository extends ReactiveMongoRepository<SaleLogData, String> {
    Flux<SaleLogData> findAllBy(Pageable pageable);
//    Flux<SaleLogData> findAllBySaleType(String saleType);
//    Flux<SaleLogData> findAllByArticleId(String articleId);
}
