package com.example.epa_inventory_logger_app.domain.usecase.sale.error;

import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import com.example.epa_inventory_logger_app.domain.model.sale.error.gateway.SaleErrorGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetAllSaleErrorsUseCase implements Function<Pageable, Flux<SaleError>> {

    private final SaleErrorGateway saleErrorGateway;

    @Override
    public Flux<SaleError> apply(Pageable pageable) {
        System.out.println("INFO: Request to get all sales errors by pagination " +
                "(Page: "+pageable.getPageNumber()+", Size: "+pageable.getPageSize()+")");
        return saleErrorGateway.getAllSaleErrors(pageable);
    }
}
