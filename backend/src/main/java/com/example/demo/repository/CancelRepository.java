package com.example.demo.repository;

import com.example.demo.entity.Cancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelRepository extends JpaRepository<Cancel,Long> {
}
