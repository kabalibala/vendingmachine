package com.wsecu.vendingmachine.services;

import com.wsecu.vendingmachine.entities.OrderDetail;
import com.wsecu.vendingmachine.entities.OrderProduct;
import com.wsecu.vendingmachine.repositories.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final OrderProductRepository orderProductRepository;
    @Transactional
    public List<OrderProduct> orderfulfillment(OrderDetail orderDetail) {
        //Multiple DB operations to update the order, inventory and shipping details.
        return orderProductRepository.saveAll(orderDetail.getProduct());
    }
    @KafkaListener(topics = "refundPayment")
    public void refundPayment(OrderDetail orderDetail) {
        //Perform refund process due to inventory unavailability
    }
}
