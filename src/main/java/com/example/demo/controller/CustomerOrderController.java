package com.example.demo.controller;

import com.example.demo.Service.CustomerOrderService;
import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.CustomerUserDTO;
import com.example.demo.entities.CustomerOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/finrad/CustomerOrder")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;
    @Autowired
    ModelMapper modelMapper;
    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createCustomerOrder(@Valid @RequestBody CustomerOrderDTO customerOrderDTO){
        CustomerOrder customerOrder=modelMapper.map(customerOrderDTO, CustomerOrder.class);
        CustomerOrder savedCustomerOrder=customerOrderService.acceptCustomerOrder(customerOrder);
        CustomerOrderDTO savedCustomerOrderDTO=modelMapper.map(savedCustomerOrder,CustomerOrderDTO.class);
        return new ResponseEntity(savedCustomerOrderDTO.getOrderId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/{orderId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrderDetailsById(@PathVariable(name="orderId") int orderId){
        CustomerOrder customerOrder=customerOrderService.getCustomerOrderById(orderId);
        CustomerOrderDTO customerOrderDTO=modelMapper.map(customerOrder,CustomerOrderDTO.class);
        return new ResponseEntity(customerOrderDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders(@Valid @RequestBody CustomerUserDTO customerUserDTO){
        List<CustomerOrder> customerOrderList=customerOrderService.getCustomerOrdersByUser(customerUserDTO.getUserId());
        return new ResponseEntity(customerOrderList,HttpStatus.OK);
    }

    @PutMapping(value="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomerOrder(@PathVariable(value="id") int id,@Valid @RequestBody CustomerOrderDTO customerOrderDTO){
        CustomerOrder customerOrder=modelMapper.map(customerOrderDTO,CustomerOrder.class);
        Integer idUpdated=customerOrderService.updateCustomerOrder(id,customerOrder);
        return new ResponseEntity(idUpdated, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(name="orderId") int orderId){
        return new ResponseEntity(customerOrderService.deleteCustomerOrder(orderId),HttpStatus.OK);
    }
}
