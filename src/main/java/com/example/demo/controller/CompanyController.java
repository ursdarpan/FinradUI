package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("finrad/v1")
public class CompanyController {

    @PostMapping("/customer")
    public ResponseEntity createCompany(CompanyDTO companyDTO){
        return null;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity getCompanyDetailsByid(@PathVariable(name="companyId") int companyId){
        return null;
    }

    @GetMapping("/customer/all")
    public ResponseEntity getAllCustomers(){
        return null;
    }

    @PutMapping("/customer/{id}")
    public void updateCustomer(){

    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(){

    }
}
