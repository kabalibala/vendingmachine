package com.wsecu.vendingmachine.services;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.entities.Payment;
import com.wsecu.vendingmachine.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    @Transactional
    public Payment makePayment(OrderDetail orderDetail) {
        return paymentRepository.save(orderDetail.getCustomer().getCustomerPayment());
    }
    @KafkaListener(topics = "refundPayment")
    public void refundPayment(OrderDetail orderDetail) {
        //Perform refund process due to inventory unavailability
    }
}
