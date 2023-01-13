package com.example.demo.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradingPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packageId;
    @Column(nullable = false,length = 30)
    private String packageDescription;

    @Column(nullable = false)
    private int startValue;

    @Column(nullable = false)
    private int endValue;

    @Column(nullable = false)
    private int packageAmount;
}
