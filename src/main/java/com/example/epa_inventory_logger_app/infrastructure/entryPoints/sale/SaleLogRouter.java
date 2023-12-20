package com.example.epa_inventory_logger_app.infrastructure.entryPoints.sale;

import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetAllSaleLogsByArticleIdLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetAllSaleLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetRetailSaleLogsUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.GetWholeSaleLogsUseCase;
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
public class SaleLogRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllSaleLog(GetAllSaleLogsUseCase getAllSaleLogUseCase) {
        return route(
                GET("/api/sale/log"),
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
                                    getAllSaleLogUseCase.apply(pageable), SaleLog.class))
                            .onErrorResume(throwable -> ServerResponse
                                    .status(HttpStatus.NO_CONTENT)
                                    .build());
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getAllSaleLogsByArticleId(GetAllSaleLogsByArticleIdLogsUseCase getAllSaleLogsByArticleIdLogsUseCase) {
        return route(
                GET("/api/sale/log/{id}"),
                request -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getAllSaleLogsByArticleIdLogsUseCase.apply(request.pathVariable("id")), SaleLog.class))
                        .onErrorResume(throwable -> ServerResponse
                                .status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(throwable.getMessage()))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getRetailSaleLogs(GetRetailSaleLogsUseCase getRetailSaleLogsUseCase) {
        return route(
                GET("/api/sale/retail"),
                request -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getRetailSaleLogsUseCase.get(), SaleLog.class))
                        .onErrorResume(throwable -> ServerResponse
                                .status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(throwable.getMessage()))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getWholeSaleLogs(GetWholeSaleLogsUseCase getWholeSaleLogsUseCase) {
        return route(
                GET("/api/sale/whole"),
                request -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getWholeSaleLogsUseCase.get(), SaleLog.class))
                        .onErrorResume(throwable -> ServerResponse
                                .status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(throwable.getMessage()))
        );
    }

}
