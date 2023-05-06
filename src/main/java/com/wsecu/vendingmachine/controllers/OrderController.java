package com.wsecu.vendingmachine.controllers;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/vm/order")
public class OrderController {
    private final OrderService orderService;
    private KafkaProducer kafkaProducer;
    @PostMapping(value = "/placeorder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderDetail orderDetail) throws Exception {
        OrderDetail ordDetail = orderService.saveOrder(orderDetail);
        //Upon successful Order Creation, send a message to Kafka Producer to initiate Payment process by passing Payment Object.
        //When the message is sent successfully, return successful order creation message to client.
        return ResponseEntity.ok(ordDetail);
    }
    @GetMapping(value = "/getallorders")
    public ResponseEntity<List<OrderDetail>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
