package com.wsecu.vendingmachine.controllers;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.entities.Payment;
import com.wsecu.vendingmachine.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/vm/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private KafkaProducer kafkaProducer;
    @PostMapping(value = "/processpayment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> makePayment(@RequestBody OrderDetail orderDetail) throws Exception {
        Payment pay = paymentService.makePayment(orderDetail);
        //Upon successful Payment, send a message to Kafka Producer to initiate inventory processing by passing Order Object.
        //When the message is sent successfully, return successful order creation message to client.
        return ResponseEntity.ok(pay);
    }
}
