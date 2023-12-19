package com.example.epa_inventory_logger_app.domain.usecase.sale.log;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllSaleLogsUseCase implements Function<Pageable, Flux<SaleLog>> {

    private final SaleLogGateway saleLogGateway;

    @Override
    public Flux<SaleLog> apply(Pageable pageable) {
        System.out.println("INFO: Request to get all sales logs by pagination " +
                "(Page: "+pageable.getPageNumber()+", Size: "+pageable.getPageSize()+")");
        return saleLogGateway.getAllSaleLogs(pageable);
    }
}
