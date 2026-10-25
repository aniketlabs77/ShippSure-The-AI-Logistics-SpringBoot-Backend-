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
import com.aniket.entity.Shipment;
import com.aniket.service.AdminService;
import com.aniket.service.CustomerService;
import com.aniket.service.DriverService;
import com.aniket.service.ShipmentService;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
	
	@Autowired
	CustomerService customerService ; 
	
	@Autowired
	ShipmentService shipmentService; 
	
	@GetMapping("/getAllShipments")
	public List<Shipment> getAllShipments(){
		return shipmentService.getAllShipments(); 
	}
	
	@GetMapping("/getShipmentById/{id}")
	public Shipment getShipmentById(@PathVariable Long id){
		return shipmentService.findById(id) ; 
	}
	
	@GetMapping("/getAllShipmentByCustomer_id/{customer_id}/{status}")
	public List<Shipment> getAllShipmentsByCustomer_id(@PathVariable String customer_id, 
			@PathVariable String status){
		
		if(status.equalsIgnoreCase("All")) {
			return shipmentService.getAllShipmentByCustomer_id(customer_id); 
		}
		
		return shipmentService.getAllShipmentsByCustomer_idAndStatus(customer_id, status); 
	}
}
