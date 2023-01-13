package com.example.demo.Service;

import com.example.demo.dao.CustomerOrderDAO;
import com.example.demo.entities.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Autowired
    CustomerOrderDAO customerOrderDAO;
    @Override
    public CustomerOrder acceptCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDAO.save(customerOrder);
    }
    @Override
    public Integer updateCustomerOrder(int id, CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public boolean deleteCustomerOrder(int id) {
        customerOrderDAO.delete(this.getCustomerOrderById(id));
        return true;
    }

    @Override
    public CustomerOrder getCustomerOrderById(int id) {
        return customerOrderDAO.findById(id).get();
    }

    @Override
    public List<CustomerOrder> getCustomerOrdersByUser(int customerUserId) {
        return null;
    }
}
