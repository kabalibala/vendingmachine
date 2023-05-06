package com.wsecu.vendingmachine.controllers;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.entities.OrderProduct;
import com.wsecu.vendingmachine.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/vm/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private KafkaProducer kafkaProducer;
    @PostMapping(value = "/orderfulfillment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> orderFulfillment(@RequestBody OrderDetail orderDetail) {
        List<OrderProduct> orderProduct = null;
        try {
            orderProduct = inventoryService.orderfulfillment(orderDetail);
            //Upon successful Payment, send a success message to Kafka Producer.
            return ResponseEntity.ok(orderProduct);
        } catch(Exception ex) {
            //Send a failure message to Kafka Producer for refund and order cancellation.
            return ResponseEntity.ok(orderProduct);
        }
    }
}
