package com.example.demo.Service;

import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerOrder;
import com.example.demo.entities.CustomerUser;

import java.util.List;

public interface CustomerOrderService {
    CustomerOrder acceptCustomerOrder(CustomerOrder customerOrder);
    Integer updateCustomerOrder(int id, CustomerOrder customerOrder);
    boolean deleteCustomerOrder(int id);
    CustomerOrder getCustomerOrderById(int id);
    List<CustomerOrder> getCustomerOrdersByUser(int customerUserId);
}
