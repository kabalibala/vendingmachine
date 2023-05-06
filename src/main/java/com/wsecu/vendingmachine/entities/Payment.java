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
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String cardholderName;
    @Column
    long cardNumber;
    @Column
    int cvvNumber;
    @Column
    int expiryMonth;
    @Column
    int expiryYear;
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    Customer customer;
    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    Address billingAddress;
}
