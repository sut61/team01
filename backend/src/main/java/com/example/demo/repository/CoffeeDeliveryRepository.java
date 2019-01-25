package com.example.demo.repository;

import com.example.demo.entity.CoffeeDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CoffeeDeliveryRepository  extends JpaRepository  <CoffeeDelivery,Long> {


}
