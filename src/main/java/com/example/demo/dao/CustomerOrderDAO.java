package com.example.demo.dao;

import com.example.demo.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDAO extends JpaRepository<CustomerOrder,Integer> {
}
