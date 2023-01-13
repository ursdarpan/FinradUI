package com.example.demo.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradingPackageDTO {
    private int packageId;
    @NotBlank
    private String packageDescription;
    @NotBlank
    private float startValue;
    @NotBlank
    private float endValue;
    private float packageAmount;
}
