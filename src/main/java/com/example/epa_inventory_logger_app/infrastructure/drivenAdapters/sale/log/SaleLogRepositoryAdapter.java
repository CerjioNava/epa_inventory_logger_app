package com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.log;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import com.example.epa_inventory_logger_app.infrastructure.drivenAdapters.sale.log.data.SaleLogData;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SaleLogRepositoryAdapter implements SaleLogGateway {

    private final SaleLogRepository repository;
    private final ObjectMapper mapper;

    @Override
    public Flux<SaleLog> getAllSaleLogs(Pageable pageable) {
        return repository
                .findAllBy(pageable)
                .switchIfEmpty(Flux.empty())
                .map(saleLogData -> mapper.map(saleLogData, SaleLog.class));
    }

    @Override
    public Flux<SaleLog> getRetailSaleLogs() {
//        return repository
//                .findAllBySaleType("RETAIL")
//                .switchIfEmpty(Mono.error(new RuntimeException("Unable to find Retail Sales")))
//                .map(saleLogData -> mapper.map(saleLogData, SaleLog.class));
        return null;
    }

    @Override
    public Flux<SaleLog> getWholeSaleLogs() {
//        return repository
//                .findAllBySaleType("WHOLE")
//                .switchIfEmpty(Mono.error(new RuntimeException("Unable to find Whole Sales")))
//                .map(saleLogData -> mapper.map(saleLogData, SaleLog.class));
        return null;
    }

    @Override
    public Flux<SaleLog> getAllSaleLogsByArticleId(String articleId) {
//        return repository
//                .findAllByArticleId(articleId)
//                .switchIfEmpty(Mono.error(new RuntimeException("Unable to find sales by articleId: "+articleId)))
//                .map(saleLogData -> mapper.map(saleLogData, SaleLog.class));
        return null;
    }

    @Override
    public Mono<SaleLog> saveSaleLog(SaleLog saleLog) {
        return repository
                .save(mapper.map(saleLog, SaleLogData.class))
                .map(saleLogData -> mapper.map(saleLogData, SaleLog.class));
    }

}
