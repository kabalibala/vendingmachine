package com.wsecu.vendingmachine.services;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.repositories.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDetailRepository orderDetailRepository;
    @Transactional
    public OrderDetail saveOrder(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
    public List<OrderDetail> getAllOrders() {
        return orderDetailRepository.findAll();
    }
    @KafkaListener(topics = "cancelorder")
    public void cancelOrder(OrderDetail orderDetail) {
        //Perform DB Operation to cancel the order due to either payment failure or inventory unavailability
    }
}
