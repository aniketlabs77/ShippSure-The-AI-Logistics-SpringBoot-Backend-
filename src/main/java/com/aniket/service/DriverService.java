package com.aniket.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.aniket.entity.Customer;
import com.aniket.entity.Driver;
import com.aniket.repo.CustomerRepo;
import com.aniket.repo.DriverRepo;

@Service
public class DriverService {

	@Autowired
	private DriverRepo driverRepo;

	public boolean register(Driver driver) {

		Driver d = driverRepo.findById(driver.getEmail()).orElse(null);

		if (d == null) {
			driverRepo.save(driver);
			return true;
		}

		return false;
	}

	public Driver findByEmail(String email) {
		return driverRepo.findById(email).orElse(null);
	}

	public Driver login(Driver driver) {
		Driver d = driverRepo.findById(driver.getEmail()).orElse(null);

		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

		if (d != null && bc.matches(driver.getPassword(), d.getPassword())) {
			return d;
		}

		return null;
	}

	public boolean setStatus(String status, String email) {
		Driver d=driverRepo.findById(email).orElse(null);	
		if(d!=null) {
			d.setStatus(status);
			driverRepo.save(d);
			return true;
		}
		return false;
	}

	public List<Driver> findAllByCityAndStatusAndRideStatus(String city,String status,String rideStatus) {
		List<Driver> drivers=driverRepo.findAllByCityAndStatusAndRideStatus(city,status,rideStatus);
		for(Driver driver:drivers) {
			driver.setDriving_license(null);
			driver.setVehicle_rc(null);
			driver.setPassword(null);
		}
		return drivers;
	}

	public String setRideStatus(String email) {
		Driver d = driverRepo.findById(email).orElse(null);	
		if (d != null) {
			if (d.getRideStatus().equalsIgnoreCase("Busy")) {
				d.setRideStatus("Free");
			} else {
				d.setRideStatus("Busy");
			}
			driverRepo.save(d);
			return d.getRideStatus();
		}
		return null;
	}
}
