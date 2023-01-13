package com.example.demo.controller;

import com.example.demo.Service.CustomerUserService;
import com.example.demo.dto.CustomerUserDTO;
import com.example.demo.entities.CustomerUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserAdminController {
    @Autowired
    CustomerUserService customerUserService;

    @Autowired
    ModelMapper modelMapper;
    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createCustomerUser(@Valid @RequestBody CustomerUserDTO customerUserDTO){
        CustomerUser customerUser=modelMapper.map(customerUserDTO, CustomerUser.class);
        CustomerUser savedCustomerUser=customerUserService.acceptCustomerUser(customerUser);
        CustomerUserDTO savedCustomerUserDTO=modelMapper.map(savedCustomerUser,CustomerUserDTO.class);
        return new ResponseEntity(savedCustomerUserDTO.getUserId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/{Id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCustomerUserById(@PathVariable(name="Id") int Id){
        CustomerUser customerUser=customerUserService.getCustomerUserById(Id);
        CustomerUserDTO customerUserDTO=modelMapper.map(customerUser,CustomerUserDTO.class);
        return new ResponseEntity(customerUserDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerUserDTO>> getAllCustomerUsers(int companyId){
        List<CustomerUser> customerUserList=customerUserService.getCustomerUsersByCompany(companyId);
        List<CustomerUserDTO> customerUserDTOList=new ArrayList<>();
        for (CustomerUser item : customerUserList) {
            customerUserDTOList.add(modelMapper.map(item,CustomerUserDTO.class));
        }
        return new ResponseEntity(customerUserDTOList,HttpStatus.OK);
    }

    @PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomerUser(@PathVariable(value="id") int id,@Valid @RequestBody CustomerUserDTO customerUserDTO){
        CustomerUser customerUser=modelMapper.map(customerUserDTO,CustomerUser.class);
        Integer idUpdated=customerUserService.updateCustomerUser(id,customerUser);
        return new ResponseEntity(idUpdated, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{Id}")
    public ResponseEntity deleteCustomer(@PathVariable(name="Id") int Id){
        return new ResponseEntity(customerUserService.deleteCustomerUser(Id),HttpStatus.OK);
    }

}
