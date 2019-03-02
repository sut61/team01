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
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockTest {


    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private AmountRepository amountRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void StocktestNullPriceperitem() {
        Stock stock = new Stock();
        stock.setPriceperitem(null);
        stock.setTotalprice(100.00);
        stock.setNote("มีปัญหาอะไร");
        stock.setDate(new Date(02-02-2018));
        try {
            entityManager.persist(stock);
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
    public void StocktestNullTotalPrice() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(null);
        stock.setNote("มีปัญหาอะไร");
        stock.setDate(new Date(02-02-2018));
        try {
            entityManager.persist(stock);
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
    public void StocktestNullDate() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(100.00);
        stock.setDate(null);
        stock.setNote("มีปัญหาอะไร");
        try {
            entityManager.persist(stock);
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
    public void StocktestSizeMinPriceperitem() {
        Stock stock = new Stock();
        stock.setPriceperitem(10.00);
        stock.setTotalprice(100.00);
        stock.setNote("ีปัญหาอะไร");
        stock.setDate(new Date(02-02-2018));
        try {
            entityManager.persist(stock);
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
    public void StocktestSizeMaxPriceperitem() {
        Stock stock = new Stock();
        stock.setPriceperitem(10000000.00);
        stock.setTotalprice(100.00);
        stock.setNote("ีปัญหาอะไร");
        stock.setDate(new Date(02-02-2018));
        try {
            entityManager.persist(stock);
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
    public void StocktestPatternNote() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(100.00);
        stock.setNote("O.O!");
        stock.setDate(new Date(02-02-2018));
        try {
            entityManager.persist(stock);
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
    public void UnittestNull() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(100.00);
        stock.setNote("มีปัญหาอะไร");
        stock.setDate((new Date(2018-02-02)));
        stock.setUnit(null);
        stock.setAmount(amountRepository.findById(1L).get());
        stock.setProduct(productRepository.findById(1L).get());

        try{
            entityManager.persist(stock);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** UnittestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }
    @Test
    public void AmounttestNull() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(100.00);
        stock.setNote("มีปัญหาอะไร");
        stock.setDate(new Date(2018-02-02));
        stock.setUnit(unitRepository.findById(1L).get());
        stock.setAmount(null);
        stock.setProduct(productRepository.findById(1L).get());

        try{
            entityManager.persist(stock);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** AmounttestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }
    @Test
    public void ProducttestNull() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(100.00);
        stock.setNote("มีปัญหาอะไร");
        stock.setDate(new Date(2018-02-02));
        stock.setUnit(unitRepository.findById(1L).get());
        stock.setAmount(amountRepository.findById(1L).get());
        stock.setProduct(null);

        try{
            entityManager.persist(stock);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** ProducttestNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");
        }
    }

}
