package com.aniket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aniket.entity.Customer;
import com.aniket.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public boolean register(Customer customer) {

		Customer c = customerRepo.findById(customer.getEmail()).orElse(null);

		if (c == null) {
			customerRepo.save(customer);
			return true;
		}

		return false;
	}

	public Customer findByEmail(String email) {
		return customerRepo.findById(email).orElse(null);
	}

	public Customer login(Customer customer) {
		Customer c = customerRepo.findById(customer.getEmail()).orElse(null);

		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

		if (c != null && bc.matches(customer.getPassword(), c.getPassword())) {
			return c;
		}

		return null;
	}
}