package com.example.epa_inventory_logger_app.infrastructure.entryPoints.sale;

import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import com.example.epa_inventory_logger_app.domain.usecase.sale.error.GetAllSaleErrorsUseCase;
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

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaleErrorRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllSaleError(GetAllSaleErrorsUseCase getAllSaleErrorsUseCase) {
        return route(
                GET("/api/sale/error"),
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
                                    getAllSaleErrorsUseCase.apply(pageable), SaleError.class))
                            .onErrorResume(throwable -> ServerResponse
                                    .status(HttpStatus.NO_CONTENT)
                                    .build());
                }
        );
    }

}
