package com.example.epa_inventory_logger_app.application.config;

import com.example.epa_inventory_logger_app.domain.model.sale.error.gateway.SaleErrorGateway;
import com.example.epa_inventory_logger_app.domain.usecase.sale.error.GetAllSaleErrorsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.error.SaveSaleErrorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleErrorUseCaseConfig {

    @Bean
    public GetAllSaleErrorsUseCase getAllSaleErrorsUseCase(SaleErrorGateway saleErrorGateway) {
        return new GetAllSaleErrorsUseCase(saleErrorGateway);
    }

    @Bean
    public SaveSaleErrorUseCase saveSaleErrorUseCase(SaleErrorGateway saleErrorGateway) {
        return new SaveSaleErrorUseCase(saleErrorGateway);
    }

}
