package com.aniket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.entity.Admin;
import com.aniket.entity.Customer;
import com.aniket.entity.Shipment;
import com.aniket.service.AdminService;
import com.aniket.service.CustomerService;
import com.aniket.service.ShipmentService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService ;  
	
	@Autowired
	ShipmentService shipmentService ; 
	
    @GetMapping("/test")
    public String test() {
        return "Customer Controller is working";
    }
    
    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }
    
	@PostMapping("/login")
	public Customer login(@RequestBody Customer customer) {
		return customerService.login(customer); 
	}
	
	
	@GetMapping("/findByEmail/{email}")
	public Customer findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email); 
	}
	
	@PostMapping("/saveorder")
	public boolean saveOrder(@RequestBody Shipment shipment) {
		return shipmentService.saveOrder(shipment); 
	}
}
