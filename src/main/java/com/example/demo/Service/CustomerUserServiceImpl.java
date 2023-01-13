package com.example.demo.Service;

import com.example.demo.dao.CustomerUserDAO;
import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserServiceImpl implements CustomerUserService{
    @Autowired
    CustomerUserDAO customerUserDAO;
    @Autowired
    CompanyService companyService;
    @Override
    public CustomerUser acceptCustomerUser(CustomerUser customerUser) {
        return customerUserDAO.save(customerUser);
    }

    @Override
    public Integer updateCustomerUser(int id, CustomerUser CustomerUser) {
        return null;
    }

    @Override
    public boolean deleteCustomerUser(int id) {
        if(this.getCustomerUserById(id)==null){
            return false;
        }
        customerUserDAO.delete(this.getCustomerUserById(id));
        return true;
    }

    @Override
    public CustomerUser getCustomerUserById(int id) {
        return customerUserDAO.findById(id).get();
    }

    @Override
    public List<CustomerUser> getCustomerUsersByCompany(int Id) {
        Company company=companyService.getCompanyById(Id);
        return customerUserDAO.findByCompany(company);
    }
}
