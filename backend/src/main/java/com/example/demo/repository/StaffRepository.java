package com.example.demo.repository;

import com.example.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface StaffRepository extends JpaRepository<Staff,Long>{
    Staff findByUsername(String username);
    Staff findBystaffId(Long staffId);
}
