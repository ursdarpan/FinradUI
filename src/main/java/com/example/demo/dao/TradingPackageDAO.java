package com.example.demo.dao;

import com.example.demo.entities.TradingPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingPackageDAO extends JpaRepository<TradingPackage,Integer> {
}
