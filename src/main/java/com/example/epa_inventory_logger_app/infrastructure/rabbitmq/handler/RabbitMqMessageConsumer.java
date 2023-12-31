package com.example.epa_inventory_logger_app.infrastructure.rabbitmq.handler;

import com.example.epa_inventory_logger_app.domain.model.inventory.error.InventoryError;
import com.example.epa_inventory_logger_app.domain.model.inventory.log.InventoryLog;
import com.example.epa_inventory_logger_app.domain.model.sale.error.SaleError;
import com.example.epa_inventory_logger_app.domain.model.sale.log.SaleLog;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.error.SaveInventoryErrorUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.inventory.log.SaveInventoryLogUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.error.SaveSaleErrorUseCase;
import com.example.epa_inventory_logger_app.domain.usecase.sale.log.SaveSaleLogUseCase;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    private final SaveInventoryErrorUseCase saveInventoryErrorUseCase;

    private final SaveInventoryLogUseCase saveInventoryLogUseCase;

    private final SaveSaleErrorUseCase saveSaleErrorUseCase;

    private final SaveSaleLogUseCase saveSaleLogUseCase;

    @Override
    public void run(String... args) throws Exception {

        receiver.consumeAutoAck(System.getenv("QUEUE_SALE_ERROR"))
                .map(message -> {
                    SaleError error = gson
                            .fromJson(new String(message.getBody()),
                                    SaleError.class);

                    saveSaleErrorUseCase.apply(error).subscribe();

                    return error;
                }).subscribe();

        receiver.consumeAutoAck(System.getenv("QUEUE_SALE_LOGS"))
                .map(message -> {
                    SaleLog log = gson
                            .fromJson(new String(message.getBody()),
                                    SaleLog.class);

                    saveSaleLogUseCase.apply(log).subscribe();

                    return log;
                }).subscribe();

        receiver.consumeAutoAck(System.getenv("QUEUE_INVENTORY_ERROR"))
                .map(message -> {
                    InventoryError error = gson
                            .fromJson(new String(message.getBody()),
                                    InventoryError.class);

                    saveInventoryErrorUseCase.apply(error).subscribe();

                    return error;
                }).subscribe();

        receiver.consumeAutoAck(System.getenv("QUEUE_INVENTORY_LOGS"))
                .map(message -> {
                    InventoryLog log = gson
                            .fromJson(new String(message.getBody()),
                                    InventoryLog.class);

                    saveInventoryLogUseCase.apply(log).subscribe();

                    return log;
                }).subscribe();

    }
}
