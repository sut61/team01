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
    public void ManutestNullName() {
        Manu manu = new Manu();
        manu.setName(null);
        manu.setPrice(100.00);
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
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);

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
        try {
            entityManager.persist(manu);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);

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
    public void ManuTypetestUnique() {
        ManuType m = new ManuType();
        m.setManut("กาแฟ");
        entityManager.persist(m);
        entityManager.flush();

        ManuType m1 = new ManuType();
        m1.setManut("กาแฟ");


        try{
            entityManager.persist(m1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM ManuTypetestUnique ======================");
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
    @Test
    public void CoffeeTypetestUnique() {
        CoffeeType c = new CoffeeType();
        c.setCoffee("อุ่นมั๊ยหละ?");
        entityManager.persist(c);
        entityManager.flush();

        CoffeeType c1 = new CoffeeType();
        c1.setCoffee("อุ่นมั๊ยหละ?");


        try{
            entityManager.persist(c1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM CoffeeTypetestUnique ======================");
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
    @Test
    public void BakeryTypetestUnique() {
        BakeryType b = new BakeryType();
        b.setBakery("กล้วยหอมจอมชน");
        entityManager.persist(b);
        entityManager.flush();

        BakeryType b1 = new BakeryType();
        b1.setBakery("กล้วยหอมจอมชน");


        try{
            entityManager.persist(b1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM BakeryTypetestUnique ======================");
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
