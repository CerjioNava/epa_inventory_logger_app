//package com.example.epa_inventory_logger_app.infrastructure.rabbitmq.config;
//
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Mono;
//import reactor.core.scheduler.Schedulers;
//import reactor.rabbitmq.*;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//
//@Configuration
//public class RabbitMQConfig {
//
//    @Value("${QUEUE_SALE_ERROR}")
//    private String QUEUE_SALE_ERROR;
//    @Value("${QUEUE_SALE_LOGS}")
//    private String QUEUE_SALE_LOGS;
//    @Value("${EXCHANGE_SALE}")
//    private String EXCHANGE_SALE;
//    @Value("${ROUTING_KEY_SALE_ERROR}")
//    private String ROUTING_KEY_SALE_ERROR;
//    @Value("${ROUTING_KEY_SALE_LOGS}")
//    private String ROUTING_KEY_SALE_LOGS;
//
//    @Value("${QUEUE_INVENTORY_ERROR}")
//    private String QUEUE_INVENTORY_ERROR;
//    @Value("${QUEUE_INVENTORY_LOGS}")
//    private String QUEUE_INVENTORY_LOGS;
//    @Value("${EXCHANGE_INVENTORY}")
//    private String EXCHANGE_INVENTORY;
//    @Value("${ROUTING_KEY_INVENTORY_ERROR}")
//    private String ROUTING_KEY_INVENTORY_ERROR;
//    @Value("${ROUTING_KEY_INVENTORY_LOGS}")
//    private String ROUTING_KEY_INVENTORY_LOGS;
//
//    @Value("${RABBIT_URI}")
//    private String RABBIT_URI;
//
//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(URI.create(RABBIT_URI));
//        var amqpAdmin =  new RabbitAdmin(connectionFactory);
//
//        // SALE RABBIT CONFIG
//        var saleExchange = new TopicExchange(EXCHANGE_SALE);
//        var saleQueueError = new Queue(QUEUE_SALE_ERROR, true, false, false);
//        var saleQueueLogs = new Queue(QUEUE_SALE_LOGS, true, false, false);
//
//        amqpAdmin.declareExchange(saleExchange);
//
//        amqpAdmin.declareQueue(saleQueueError);
//        amqpAdmin.declareQueue(saleQueueLogs);
//
//        amqpAdmin.declareBinding(BindingBuilder.bind(saleQueueError).to(saleExchange).with(ROUTING_KEY_SALE_ERROR));
//        amqpAdmin.declareBinding(BindingBuilder.bind(saleQueueLogs).to(saleExchange).with(ROUTING_KEY_SALE_LOGS));
//
//        // INVENTORY RABBIT CONFIG
//        var inventoryExchange = new TopicExchange(EXCHANGE_INVENTORY);
//        var inventoryQueueError = new Queue(QUEUE_INVENTORY_ERROR, true, false, false);
//        var inventoryQueueLogs = new Queue(QUEUE_INVENTORY_LOGS, true, false, false);
//
//        amqpAdmin.declareExchange(inventoryExchange);
//
//        amqpAdmin.declareQueue(inventoryQueueError);
//        amqpAdmin.declareQueue(inventoryQueueLogs);
//
//        amqpAdmin.declareBinding(BindingBuilder.bind(inventoryQueueError).to(inventoryExchange).with(ROUTING_KEY_INVENTORY_ERROR));
//        amqpAdmin.declareBinding(BindingBuilder.bind(inventoryQueueLogs).to(inventoryExchange).with(ROUTING_KEY_INVENTORY_LOGS));
//
//        return amqpAdmin;
//    }
//
//
//    @Bean
//    public ConnectionFactory connectionFactory() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.useNio();
//        connectionFactory.setUri(RABBIT_URI);
//        connectionFactory.setVirtualHost("/");
//        return connectionFactory;
//    }
//
//    @Bean
//    public Mono<Connection> connectionMono(@Value("spring.application.name") String name, ConnectionFactory connectionFactory)  {
//        return Mono.fromCallable(() -> connectionFactory.newConnection(name)).cache();
//    }
//
//    @Bean
//    public SenderOptions senderOptions(Mono<Connection> connectionMono) {
//        return new SenderOptions()
//                .connectionMono(connectionMono)
//                .resourceManagementScheduler(Schedulers.boundedElastic());
//    }
//
//    @Bean
//    public Sender sender(SenderOptions senderOptions) {
//        return RabbitFlux.createSender(senderOptions);
//    }
//
//
//    @Bean
//    public ReceiverOptions receiverOptions(Mono<Connection> connectionMono) {
//        return new ReceiverOptions()
//                .connectionMono(connectionMono);
//    }
//
//    @Bean
//    public Receiver receiver(ReceiverOptions receiverOptions) {
//        return RabbitFlux.createReceiver(receiverOptions);
//    }
//}
