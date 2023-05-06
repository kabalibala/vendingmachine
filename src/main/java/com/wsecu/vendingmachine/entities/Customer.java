package com.wsecu.vendingmachine.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String customerName;
    @Column
    Address customerAddress;
    @Column
    String customerPhone;
    @Column
    String customerEmail;
    @OneToMany(mappedBy="customer")
    Set<Payment> customerPayment;
}
