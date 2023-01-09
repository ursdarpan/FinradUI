package com.example.demo.dao;

import com.example.demo.entities.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerUserDAO extends JpaRepository<CustomerUser,Integer> {
}
