package com.example.demo.dao;

import com.example.demo.entities.Company;
import com.example.demo.entities.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyDAO extends JpaRepository<Company,Integer> {
     public Company findByCompanyName(String companyName);
}
