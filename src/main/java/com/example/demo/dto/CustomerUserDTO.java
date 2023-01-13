package com.example.demo.dto;

import com.example.demo.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUserDTO {
    private int userId;
    @NotBlank
    private String userName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String password;
    @Email
    private String emailId;
    //@Pattern(regexp="/^(\\+\\d{1,3}[- ]?)?\\d{10}$/")
    private String mobileNumber;
    private Company company;
}
