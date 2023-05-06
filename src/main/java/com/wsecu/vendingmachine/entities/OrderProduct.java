package com.wsecu.vendingmachine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String productName;
    @Column
    int productQty;
    @Column
    double productCost;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    OrderDetail order;
}
