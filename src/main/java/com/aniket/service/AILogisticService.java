package com.aniket.service;

import com.aniket.repo.DriverRepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.entity.Customer;
import com.aniket.entity.Driver;
import com.aniket.repo.CustomerRepo;

@Service
public class AILogisticService {
	
	
	@Autowired
	private DriverRepo driverRepo;
	@Autowired
	private CustomerRepo customerRepo;


	AILogisticService(DriverRepo driverRepo) {
		this.driverRepo = driverRepo;
	}
	
	
	public boolean register(Customer customer) {
		Customer c=customerRepo.findById(customer.getEmail()).orElse(null);	
		if(c==null) {
			customerRepo.save(customer);
			return true;
		}
		return false;
	}


	public boolean updatePassword(List<String> data) {
		String email = data.get(0); 
		String password = data.get(1); 
		
		if(driverRepo.findById(email).orElse(null) != null) {
			Driver d = driverRepo.findById(email).orElse(null); 
			
			d.setPassword(password);
			driverRepo.save(d); 
		}
		else {
			Customer c = customerRepo.findById(email).orElse(null);
			c.setPassword(password);
			customerRepo.save(c); 
			
		}
		return true;
	}
}
