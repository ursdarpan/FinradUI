package com.example.demo.Service;

import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Override
    public CustomerOrder acceptCustomerOrder(CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public Integer updateCustomerOrder(int id, CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public Company getCustomerOrderDetails(int id) {
        return null;
    }

    @Override
    public boolean deleteCustomerOrder(int id) {
        return false;
    }

    @Override
    public CustomerOrder getCustomerOrderById(int id) {
        return null;
    }

    @Override
    public List<CustomerOrder> getCustomerOrdersByUser(int customerUserId) {
        return null;
    }
}
