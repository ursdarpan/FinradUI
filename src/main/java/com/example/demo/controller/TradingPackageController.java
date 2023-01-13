package com.example.demo.controller;

import com.example.demo.Service.TradingPackageService;
import com.example.demo.dto.CustomerUserDTO;
import com.example.demo.dto.TradingPackageDTO;
import com.example.demo.entities.TradingPackage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/finrad/TradingPackage")
public class TradingPackageController {
    @Autowired
    TradingPackageService tradingPackageService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createTradingPackage(@Valid @RequestBody TradingPackageDTO tradingPackageDTO){
        TradingPackage tradingPackage=modelMapper.map(tradingPackageDTO, TradingPackage.class);
        TradingPackage savedTradingPackage=tradingPackageService.acceptTradingPackage(tradingPackage);
        TradingPackageDTO savedTradingPackageDTO=modelMapper.map(savedTradingPackage,TradingPackageDTO.class);
        return new ResponseEntity(savedTradingPackageDTO.getPackageId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTradingPackageById(@PathVariable(name="Id") int Id){
        TradingPackage tradingPackage=tradingPackageService.getTradingPackageById(Id);
        TradingPackageDTO tradingPackageDTO=modelMapper.map(tradingPackage,TradingPackageDTO.class);
        return new ResponseEntity(tradingPackageDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TradingPackage>> getAllTradingPackages(@Valid @RequestBody CustomerUserDTO customerUserDTO){
        List<TradingPackage> tradingPackageList=tradingPackageService.getTradingPackagesByUser(customerUserDTO.getUserId());
        return new ResponseEntity(tradingPackageList,HttpStatus.OK);
    }

    @PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTradingPackage(@PathVariable(value="id") int id,@Valid @RequestBody TradingPackageDTO tradingPackageDTO){
        TradingPackage tradingPackage=modelMapper.map(tradingPackageDTO,TradingPackage.class);
        Integer idUpdated=tradingPackageService.updateTradingPackage(id,tradingPackage);
        return new ResponseEntity(idUpdated, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{Id}")
    public ResponseEntity deleteCustomer(@PathVariable(name="Id") int Id){
        return new ResponseEntity(tradingPackageService.deleteTradingPackage(Id),HttpStatus.OK);
    }
}
