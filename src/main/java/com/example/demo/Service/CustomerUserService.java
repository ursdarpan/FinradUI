package com.example.demo.Service;

import com.example.demo.entities.CustomerUser;

import java.util.List;

public interface CustomerUserService {
    CustomerUser acceptCustomerUser(CustomerUser CustomerUser);
    Integer updateCustomerUser(int id, CustomerUser CustomerUser);
    boolean deleteCustomerUser(int id);
    CustomerUser getCustomerUserById(int id);
    List<CustomerUser> getCustomerUsersByCompany(int companyId);
}
