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
    public void StocktestNullTotalPrice() {
        Stock stock = new Stock();
        stock.setPriceperitem(100.00);
        stock.setTotalprice(null);
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
        stock.setDate(null);
        stock.setNote("ีปัญหาอะไร");
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
        stock.setDate(null);
        stock.setNote("ีปัญหาอะไร");
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
        stock.setDate(null);
        stock.setNote("O.O!");
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
    public void UnittestUnique() {
        Unit u = new Unit();
        u.setUnit("กล่อง");
        entityManager.persist(u);
        entityManager.flush();

        Unit u1 = new Unit();
        u1.setUnit("กล่อง");


        try{
            entityManager.persist(u1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM UnittestUnique ======================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("==================================================================");
            e.printStackTrace();
        }
    }

}
