package com.aniket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.entity.Shipment;
import com.aniket.repo.ShipmentRepo;

@Service
public class ShipmentService {
	
	@Autowired
	ShipmentRepo shipmentRepo ; 
	
	public boolean saveOrder(Shipment shipment) {
		shipmentRepo.save(shipment);
		return true;
	}

	public List<Shipment> getAllShipments() {
		return shipmentRepo.findAll(); 
	}

	public List<Shipment> getAllShipmentByCustomer_id(String customer_id) {
		return shipmentRepo.findAllByCustomer_id(customer_id); 
	}



	public List<Shipment> getAllShipmentsByCustomer_idAndStatus(String customer_id, String status) {
		return shipmentRepo.findShipmentsByCustomerAndStatus(customer_id,status);
	}

	public Shipment findById(Long id) {
		return shipmentRepo.findById(id).orElse(null); 
	}


}
