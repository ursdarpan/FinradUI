package com.example.demo.dao;

import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CustomerUserDAO extends JpaRepository<CustomerUser,Integer> {
    List<CustomerUser> findByCompany(Company company);
}
