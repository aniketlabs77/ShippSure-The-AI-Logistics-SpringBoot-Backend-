package com.aniket.controller;

import java.util.List;

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
import com.aniket.entity.Driver;
import com.aniket.service.AdminService;
import com.aniket.service.CustomerService;
import com.aniket.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	DriverService driverService ; 
	
    @GetMapping("/test")
    public String test() {
        return "Driver Controller is working";
    }
    
    @PostMapping("/register")
    public boolean register(@RequestBody Driver driver) {
        return driverService.register(driver);
    }
    
    
	@PutMapping("/setStatus/{status}/{email}")
	public boolean setStatus(@PathVariable String status,@PathVariable String email) {
		return driverService.setStatus(status,email);
	}
    
//	@PostMapping("/login")
//	public Customer login(@RequestBody Customer customer) {
//		return customerService.login(customer); 
//	}
	
	
	@GetMapping("/findByEmail/{email}")
	public Driver findByEmail(@PathVariable String email) {
		return driverService.findByEmail(email); 
	}
	
	
	@GetMapping("/findAllByCityAndStatusAndRideStatus/{city}/{status}/{rideStatus}")
	public List<Driver> findAllByCityAndStatusAndRideStatus(@PathVariable String city,@PathVariable String status,@PathVariable String rideStatus) {
		return driverService.findAllByCityAndStatusAndRideStatus(city,status,rideStatus);
	}
	
	@PutMapping("/setRideStatus/{email}")
	public String setRideStatus(@PathVariable String email) {
		return driverService.setRideStatus(email);
	}
	
}
