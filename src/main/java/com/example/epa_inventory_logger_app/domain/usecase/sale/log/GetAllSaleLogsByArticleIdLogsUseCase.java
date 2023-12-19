package com.example.epa_inventory_logger_app.domain.usecase.sale.log;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllSaleLogsByArticleIdLogsUseCase implements Function<String, Flux<SaleLog>> {

    private final SaleLogGateway saleLogGateway;

    @Override
    public Flux<SaleLog> apply(String articleId) {
        System.out.println("INFO: Request to get all inventory logs by articleId: "+articleId);
        return saleLogGateway.getAllSaleLogsByArticleId(articleId);
    }
}
