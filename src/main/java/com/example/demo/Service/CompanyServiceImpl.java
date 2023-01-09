package com.example.demo.Service;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyDAO companyDAO;
    @Override
    public Company acceptCompanyDetails(Company company) {
        return companyDAO.save(company);
    }
    @Override
    public Company updateCompanyDetails(int id, Company company) {
        return null;
    }
    @Override
    public Company getCompanyDetails(int id) {
        return companyDAO.findById(id).get();
    }

    @Override
    public Company getCompanyDetailsByCompanyName(String companyName) {
        return null;
    }

    @Override
    public boolean deleteCompany(int id) {
        return false;
    }

    @Override
    public List<Company> getAllCompanyDetails() {
        return null;
    }
}
