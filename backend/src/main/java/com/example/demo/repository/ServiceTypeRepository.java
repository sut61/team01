package com.example.demo.repository;

import com.example.demo.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ServiceTypeRepository extends JpaRepository <ServiceType,Long>{
   ServiceType findByServiceTypeId(Long serviceTypeId);

}
