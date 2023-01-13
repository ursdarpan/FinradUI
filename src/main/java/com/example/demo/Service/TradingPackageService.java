package com.example.demo.Service;

import com.example.demo.entities.TradingPackage;
import java.util.List;

public interface TradingPackageService {
    TradingPackage acceptTradingPackage(TradingPackage tradingPackage);
    int updateTradingPackage(int id, TradingPackage tradingPackage);
    boolean deleteTradingPackage(int id);
    TradingPackage getTradingPackageById(int id);
    List<TradingPackage> getTradingPackagesByUser(int customerUserId);
}
