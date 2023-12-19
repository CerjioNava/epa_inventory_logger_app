package com.example.epa_inventory_logger_app.application.config;

import com.example.epa_inventory_logger_app.domain.model.sale.log.gateway.SaleLogGateway;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetAllSaleLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetRetailSaleLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetWholeSaleLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.SaveSaleLogUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleLogUseCaseConfig {

    @Bean
    public GetAllSaleLogsUseCase getAllSaleLogsUseCase(SaleLogGateway saleLogGateway) {
        return new GetAllSaleLogsUseCase(saleLogGateway);
    }

    @Bean
    public GetRetailSaleLogsUseCase getRetailSaleLogsUseCase(SaleLogGateway saleLogGateway) {
        return new GetRetailSaleLogsUseCase(saleLogGateway);
    }

    @Bean
    public GetWholeSaleLogsUseCase getWholeSaleLogsUseCase(SaleLogGateway saleLogGateway) {
        return new GetWholeSaleLogsUseCase(saleLogGateway);
    }

    @Bean
    public SaveSaleLogUseCase saveSaleLogUseCase(SaleLogGateway saleLogGateway) {
        return new SaveSaleLogUseCase(saleLogGateway);
    }

}
