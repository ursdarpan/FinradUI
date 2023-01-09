package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int orderId;
    @ManyToOne
    @JoinColumn(name="userId",nullable = false)
    private CustomerUser customerUser;
    @OneToMany(mappedBy = "packageId",cascade = CascadeType.ALL)
    private Set<TradingPackage> tradingPackageSet;
    private float orderAmount;
    private float Discount;
}
