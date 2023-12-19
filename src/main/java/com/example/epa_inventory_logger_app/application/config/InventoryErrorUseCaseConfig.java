package com.example.epa_inventory_logger_app.application.config;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.gateway.InventoryErrorGateway;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.error.GetAllInventoryErrorsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.error.SaveInventoryErrorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryErrorUseCaseConfig {

    @Bean
    public GetAllInventoryErrorsUseCase getAllInventoryErrorsUseCase(InventoryErrorGateway inventoryErrorGateway) {
        return new GetAllInventoryErrorsUseCase(inventoryErrorGateway);
    }

    @Bean
    public SaveInventoryErrorUseCase saveInventoryErrorUseCase(InventoryErrorGateway inventoryErrorGateway) {
        return new SaveInventoryErrorUseCase(inventoryErrorGateway);
    }

}
