package com.aniket.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aniket.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver, String>{

	List<Driver> getAllByStatus(String status);

	List<Driver> findAllByCityAndStatusAndRideStatus(String city, String status, String rideStatus);
	
}
