package com.example.demo.repository;

import com.example.demo.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeliveryRepository extends JpaRepository <Delivery, Long> {


}
