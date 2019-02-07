package com.example.demo.repository;

import com.example.demo.entity.Typereward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TyperewardRepository extends JpaRepository<Typereward,Long> {


//    Point findByPoint(Long id);
//    Point findByPoint(Long id);
//    Point findByPoint(Long id);\//    Point findByPoint(Long id)//    Point findByPoint(Long iPoint findByPoint(Long id)d)


}