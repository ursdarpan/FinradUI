package com.example.demo.Service;

import com.example.demo.dao.TradingPackageDAO;
import com.example.demo.entities.TradingPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradingPackageServiceImpl implements TradingPackageService {
    @Autowired
    TradingPackageDAO tradingPackageDAO;

    @Override
    public TradingPackage acceptTradingPackage(TradingPackage tradingPackage) {
        return tradingPackageDAO.save(tradingPackage);
    }

    @Override
    public int updateTradingPackage(int id, TradingPackage tradingPackage) {
        return 1;
    }

    @Override
    public boolean deleteTradingPackage(int id) {
        tradingPackageDAO.delete(this.getTradingPackageById(id));
        return true;
    }

    @Override
    public TradingPackage getTradingPackageById(int id) {
        return tradingPackageDAO.findById(id).get();
    }

    @Override
    public List<TradingPackage> getTradingPackagesByUser(int customerUserId) {
        return null;
    }
}
