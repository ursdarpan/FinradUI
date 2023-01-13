package com.example.demo.dto;

import com.example.demo.entities.CustomerUser;
import com.example.demo.entities.TradingPackage;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {
    private int orderId;
    @NotBlank
    private CustomerUser customerUser;
    private Set<TradingPackage> tradingPackageSet;
    @NotBlank
    private float orderAmount;
    private float Discount;
}
