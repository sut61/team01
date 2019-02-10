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
public class StockTest {


    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ManuRepository manuRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
//    ===============================================Sprint#1===============================================;
//    @Test
//    public void testNullPrice() {
//        Manu manu = new Manu();
//        manu.setPrice(null);
//        try {
//            entityManager.persist(manu);
//            entityManager.flush();
//            fail("Price is null");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 2);
//            System.out.println("========================================testNullPrice Manu====================================================================================================");
//            e.printStackTrace();
//            System.out.println("========================================testNullPrice Manu====================================================================================================");
//            System.out.println(e);
//            System.out.println("========================================testNullPrice Manu====================================================================================================");
//        }
//    }
    public void testNullName() {
        Manu manu = new Manu();
        manu.setName(null);
        try {
            entityManager.persist(manu);
            entityManager.flush();
            fail("Name is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println("========================================testNullName Manu====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testNullName Manu====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testNullName Manu====================================================================================================");
        }
    }
    @Test
    public void testSizeMinName() {
        Manu manu = new Manu();
        manu.setName("G");
        try {
            entityManager.persist(manu);
            entityManager.flush();
            fail("Name is SizeLong");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================testSizeMinName Manu====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testSizeMinName Manu====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testSizeMinName Manu====================================================================================================");
        }
    }
    @Test
    public void testSizeMaxName() {
        Manu manu = new Manu();
        manu.setName("GTXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        try {
            entityManager.persist(manu);
            entityManager.flush();
            fail("Name is SizeShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("========================================testSizeMaxName Manu====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testSizeMaxName Manu====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testSizeMaxName Manu====================================================================================================");
        }
    }
    @Test
    public void testPatternName() {
        Manu manu = new Manu();
        manu.setName("0.0!");
        try {
            entityManager.persist(manu);
            entityManager.flush();
            fail("Name too ACSII");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================testPatternName Manu====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testPatternName Manu====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testPatternName Manu====================================================================================================");
        }
    }

//     ===============================================Sprint#2===============================================;
    @Test
    public void testNullPriceperitem() {
        Stock stock = new Stock();
        stock.setPriceperitem(null);
        try {
            entityManager.persist(stock);
            entityManager.flush();
            fail("Date is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println("==================================================testNullPriceperitem Stock==========================================================================================");
            e.printStackTrace();
            System.out.println("==================================================testNullPriceperitem Stock==========================================================================================");
            System.out.println(e);
            System.out.println("==================================================testNullPriceperitem Stock==========================================================================================");
        }
    }
    @Test
    public void testNullDate() {
        Stock stock = new Stock();
        stock.setDate(null);
        try {
            entityManager.persist(stock);
            entityManager.flush();
            fail("Note is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println("==================================================testNullDate Stock==========================================================================================");
            e.printStackTrace();
            System.out.println("==================================================testNullDate Stock==========================================================================================");
            System.out.println(e);
            System.out.println("==================================================testNullDate Stock==========================================================================================");
        }
    }
    @Test
    public void testSizeMinNote() {
        Stock stock = new Stock();
        stock.setNote("G");
        try {
            entityManager.persist(stock);
            entityManager.flush();
            fail("Note is SizeLong");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println("========================================testSizeMinNote Stock====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testSizeMinNote Stock====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testSizeMinNote Stock====================================================================================================");
        }
    }
    @Test
    public void testSizeMaxNote() {
        Stock stock = new Stock();
        stock.setNote("GTXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        try {
            entityManager.persist(stock);
            entityManager.flush();
            fail("Name is SizeShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
            System.out.println("========================================testSizeMaxNote Stock====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testSizeMaxNote Stock====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testSizeMaxNote Stock====================================================================================================");
        }
    }
    @Test
    public void testPatternNote() {
        Manu manu = new Manu();
        manu.setName("0.0!");
        try {
            entityManager.persist(manu);
            entityManager.flush();
            fail("Note too ACSII");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("========================================testPatternNote Stock====================================================================================================");
            e.printStackTrace();
            System.out.println("========================================testPatternNote Stock====================================================================================================");
            System.out.println(e);
            System.out.println("========================================testPatternNote Stock====================================================================================================");
        }
    }

}
