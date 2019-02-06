package com.example.demo.repository;

import com.example.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StaffRepository extends JpaRepository<Staff,Long>{
    Staff findByUsername(String username);
//    Staff findById(Long staffId);
}
