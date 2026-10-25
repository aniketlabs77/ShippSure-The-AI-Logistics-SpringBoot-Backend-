package com.aniket.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aniket.entity.Admin;
import com.aniket.entity.Shipment;

@Repository
public interface ShipmentRepo extends JpaRepository<Shipment, Long>{
	
	
	@Query("SELECT s FROM Shipment s WHERE s.customer_id = :customer_id")
	List<Shipment> findAllByCustomer_id(String customer_id);

	@Query("SELECT s FROM Shipment s WHERE s.customer_id = :customer_id AND s.status = :status")
	List<Shipment> findShipmentsByCustomerAndStatus(String customer_id, String status);

}
