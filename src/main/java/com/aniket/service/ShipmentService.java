package com.aniket.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniket.entity.Shipment;
import com.aniket.repo.ShipmentRepo;

@Service
public class ShipmentService {

	@Autowired
	ShipmentRepo shipmentRepo;

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
		return shipmentRepo.findShipmentsByCustomerAndStatus(customer_id, status);
	}

	public Shipment findById(Long id) {
		return shipmentRepo.findById(id).orElse(null);
	}

	public List<Shipment> getAllShipmentByDriver_id(String driver_id) {
		return shipmentRepo.findAllByDriver_id(driver_id);
	}

	public List<Shipment> getAllShipmentByDriver_idAndStatus(String driver_id, String status) {
		return shipmentRepo.findAllByDriver_idAndStatus(driver_id, status);
	}

	public Boolean setStatus(String status, Long id) {
		Shipment s = shipmentRepo.findById(id).orElse(null);
		if (s != null) {
			s.setStatus(status);

			// If the package is marked Delivered, automatically record the delivery
			// timestamp!
			if (status.equalsIgnoreCase("Delivered")) {
				s.setDrop_datetime(LocalDateTime.now());
			}

			shipmentRepo.save(s);
			return true;
		}
		return false;
	}

	public boolean updateLocation(double current_latitude, double current_longitude, Long id) {
		Shipment s = shipmentRepo.findById(id).orElse(null);

		if (s != null) {
			s.setCurrent_latitude(current_latitude);
			s.setCurrent_longitude(current_longitude);
			shipmentRepo.save(s);
			return true;

		}
		
		return false;
	}
}
