package com.example.demo.Service;

import com.example.demo.dao.CompanyDAO;
import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerUser;
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
    public Integer updateCompanyDetails(int id, Company company) {
        return id;
    }

    @Override
    public Company getCompanyById(int id){
        return companyDAO.findById(id).get();
    }
    @Override
    public Company getCompanyDetails(int id) {
        return companyDAO.findById(id).get();
    }

    @Override
    public Company getCompanyDetailsByCompanyName(String companyName) {
        return companyDAO.findByCompanyName(companyName);
    }

    @Override
    public boolean deleteCompany(int id) {
        Company company=this.getCompanyById(id);
        if(company==null){
            return false;
        }
        companyDAO.delete(company);
        return true;
    }

    @Override
    public List<Company> getAllCompanyDetails() {
        return companyDAO.findAll();
    }
}
