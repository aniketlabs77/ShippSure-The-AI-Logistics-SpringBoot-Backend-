package com.aniket.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniket.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
