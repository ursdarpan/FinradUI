package com.example.demo.Service;

import com.example.demo.entities.Company;

import java.util.List;

public interface CompanyService {
    Company acceptCompanyDetails(Company company);
    Company updateCompanyDetails(int id, Company company);
    Company getCompanyDetails(int id) ;
    Company getCompanyDetailsByCompanyName(String companyName) ;
    boolean deleteCompany(int id);
    List<Company> getAllCompanyDetails();
}
