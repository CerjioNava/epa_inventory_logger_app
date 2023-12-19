package com.example.epa_inventory_logger_app.domain.model.sale.log.gateway;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleLogGateway {

    Flux<SaleLog> getAllSaleLogs(Pageable pageable);
    Flux<SaleLog> getRetailSaleLogs();
    Flux<SaleLog> getWholeSaleLogs();
    Flux<SaleLog> getAllSaleLogsByArticleId(String articleId);
    Mono<SaleLog> saveSaleLog(SaleLog saleLog);

}
