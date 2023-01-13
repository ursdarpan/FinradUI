package com.example.demo.Service;

import com.example.demo.entities.Company;

import java.util.List;

public interface CompanyService {
    Company acceptCompanyDetails(Company company);
    Integer updateCompanyDetails(int id, Company company);
    Company getCompanyDetails(int id) ;
    Company getCompanyDetailsByCompanyName(String companyName) ;
    boolean deleteCompany(int id);
    Company getCompanyById(int id);
    List<Company> getAllCompanyDetails();
}
