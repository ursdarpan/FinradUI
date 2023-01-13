package com.example.demo.dto;

import com.example.demo.entities.CustomerUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private int companyId;
    @NotBlank
    private String companyName;
    private String companyAddress;
}
