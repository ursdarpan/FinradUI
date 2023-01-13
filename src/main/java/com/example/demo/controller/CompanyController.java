package com.example.demo.controller;

import com.example.demo.Service.CompanyService;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.entities.Company;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/finrad/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createCompany(@Valid @RequestBody CompanyDTO companyDTO){
        Company company=modelMapper.map(companyDTO,Company.class);
        Company savedCompany=companyService.acceptCompanyDetails(company);
        CompanyDTO savedCompanyDTO=modelMapper.map(savedCompany,CompanyDTO.class);
        return new ResponseEntity(savedCompanyDTO.getCompanyId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/{companyId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCompanyDetailsById(@PathVariable(name="companyId") int companyId){
        Company company=companyService.getCompanyById(companyId);
        CompanyDTO companyDTO=modelMapper.map(company,CompanyDTO.class);
        return new ResponseEntity(companyDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAllCustomers(){
        List<Company> companyList=companyService.getAllCompanyDetails();
        return new ResponseEntity(companyList,HttpStatus.OK);
    }

    @PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable(value="id") int id,@Valid @RequestBody CompanyDTO companyDTO){
        Company company=modelMapper.map(companyDTO,Company.class);
        Integer idUpdated=companyService.updateCompanyDetails(id,company);
        return new ResponseEntity(idUpdated, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(name="companyId") int companyId){
        return new ResponseEntity(companyService.deleteCompany(companyId),HttpStatus.OK);
    }
}
