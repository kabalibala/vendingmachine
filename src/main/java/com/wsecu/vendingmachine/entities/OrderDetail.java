package com.wsecu.vendingmachine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    Date orderDate;
    @OneToMany(mappedBy="order")
    List<OrderProduct> product;
    @Column
    double orderTotal;
    @ManyToOne
    Customer customer;
}
