package com.aniket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.entity.Customer;
import com.aniket.service.AILogisticService;

@RestController
public class AiLogisticController {

	@Autowired 
	AILogisticService aiLogisticsService ; 
	
	@PostMapping("/register")
	public boolean register(@RequestBody Customer customer) {
		return aiLogisticsService.register(customer);
	}
	
	@PutMapping("/updatePassword")
	public boolean updatePassword(@RequestBody List<String> data) {
		return aiLogisticsService.updatePassword(data);
	}
}
