package com.example.epa_inventory_logger_app.infrastructure.entryPoints.inventory;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.error.GetAllInventoryErrorsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.error.SaveInventoryErrorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class InventoryErrorRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllInventoryError(GetAllInventoryErrorsUseCase getAllInventoryErrorsUseCase) {
        return route(
                GET("/api/inventory/error"),
                request -> {
                    Optional<String> page = request.queryParam("page");
                    Optional<String> size = request.queryParam("size");
                    Pageable pageable = PageRequest.of(
                            page.map(Integer::parseInt).orElse(0),
                            size.map(Integer::parseInt).orElse(20)
                    );
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromPublisher(
                                    getAllInventoryErrorsUseCase.apply(pageable), InventoryError.class))
                            .onErrorResume(throwable -> ServerResponse
                                    .status(HttpStatus.NO_CONTENT)
                                    .build());
                }
        );
    }

}
