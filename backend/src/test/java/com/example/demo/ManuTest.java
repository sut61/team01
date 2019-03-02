package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ManuTest {

    @Autowired
    private ManuRepository manuRepository;
    @Autowired
    private ManuTypeRepository manuTypeRepository;
    @Autowired
    private BakeryTypeRepository bakeryTypeRepository;
    @Autowired
    private CoffeeTypeRepository coffeeTypeRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void ManutestSuccess() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(100.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());
        try {
            entityManager.persist(manu);
            entityManager.flush();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println("Test Successful");
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }
    @Test
    public void ManutestNullName() {
        Manu manu = new Manu();
        manu.setName(null);
        manu.setPrice(100.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println( e );
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
    @Test
    public void ManutestSizeMinPrice() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(10.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println( e );
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
    @Test
    public void ManutestSizeMaxPrice() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(10000000.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println( e );
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
    @Test
    public void ManutestPatternName() {
        Manu manu = new Manu();
        manu.setName("0.0!");
        manu.setPrice(100.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println( e );
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
    @Test
    public void ManuTypetestNull() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(100.00);
        manu.setManutype(null);
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());

        try{
            entityManager.persist(manu);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** ManuTypetestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }
    @Test
    public void CoffeetypetestSuccess() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(100.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(null);
        manu.setBakerytype(bakeryTypeRepository.findById(1L).get());

        try{
            entityManager.persist(manu);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** CoffeeTypetestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }
    @Test
    public void BakerytypetestSuccess() {
        Manu manu = new Manu();
        manu.setName("ชาชมพู");
        manu.setPrice(100.00);
        manu.setManutype(manuTypeRepository.findById(1L).get());
        manu.setCoffeetype(coffeeTypeRepository.findById(1L).get());
        manu.setBakerytype(null);

        try{
            entityManager.persist(manu);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** BakeryTypetestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }
}
