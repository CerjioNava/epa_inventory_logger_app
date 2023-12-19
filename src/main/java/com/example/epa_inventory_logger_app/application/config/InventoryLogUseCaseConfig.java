package com.example.epa_inventory_logger_app.application.config;

import com.example.epa_inventory_logger_app.domain.model.inventory.log.gateway.InventoryLogGateway;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.log.GetAllInventoryLogsByArticleIdLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.log.GetAllInventoryLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.log.SaveInventoryLogUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryLogUseCaseConfig {

    @Bean
    public GetAllInventoryLogsUseCase getAllInventoryLogsUseCase(InventoryLogGateway inventoryLogGateway) {
        return new GetAllInventoryLogsUseCase(inventoryLogGateway);
    }

    @Bean
    public GetAllInventoryLogsByArticleIdLogsUseCase getAllInventoryLogsByArticleIdLogsUseCase(InventoryLogGateway inventoryLogGateway) {
        return new GetAllInventoryLogsByArticleIdLogsUseCase(inventoryLogGateway);
    }

    @Bean
    public SaveInventoryLogUseCase saveInventoryLogUseCase(InventoryLogGateway inventoryLogGateway) {
        return new SaveInventoryLogUseCase(inventoryLogGateway);
    }

}
