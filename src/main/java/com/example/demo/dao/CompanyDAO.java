package com.example.demo.dao;

import com.example.demo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDAO extends JpaRepository<Company,Integer> {
}