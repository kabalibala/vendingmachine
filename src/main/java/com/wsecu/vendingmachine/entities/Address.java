package com.wsecu.vendingmachine.entities;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String customerAddress;
    @Column
    String customerCity;
    @Column
    String customerState;
    @Column
    int customerZip;
}
