package com.example.demo;

import com.example.demo.entity.Point;
import com.example.demo.entity.Reward;
import com.example.demo.repository.PointRepository;
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
public class PointRewardTest {


    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //============================================================================================
    //******************************************SPRINT 1******************************************
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=========================================Point Entity=======================================


    @Test
    //test null date
    public void testNullOther() {
        Point point = new Point();
        point.setOther(null);
        point.setDate(null);
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("other is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }
    @Test
    // no fail
    public void testNotnullOther() {
        Point point = new Point();
        point.setOther("Good Other");
        point.setDate(null);
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("Success full");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }
    @Test
    //min other
    public void testSizeMinother() {
        Point point = new Point();
        point.setOther("GG");
        point.setDate(null);
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("other too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }

    @Test
    //max other
    public void testSizMaxeother() {
        Point point = new Point();
        point.setOther("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        point.setDate(null);
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("other too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }




    //============================================================================================
    //******************************************SPRINT 2******************************************
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=========================================Reward Entity======================================





    @Test
    //Don't fail
    public void testGoodAmount() {
        Reward reward = new Reward();
        reward.setCategory("Oh na na na");
        reward.setAmount(1);
        try {
            entityManager.persist(reward);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }



    @Test
    //max max category
    public void testMaxCategory() {
        Reward reward = new Reward();
        reward.setCategory("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        reward.setAmount(1);
        try {
            entityManager.persist(reward);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }


    @Test
    //max min category
    public void testMinCategory() {
        Reward reward = new Reward();
        reward.setCategory("WW");
        reward.setAmount(1);
        try {
            entityManager.persist(reward);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }

    @Test
    //max null category
    public void testAmountNegative() {
        Reward reward = new Reward();
        reward.setCategory(null);
        reward.setAmount(1);
        try {
            entityManager.persist(reward);
            entityManager.flush();
            fail("category null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }

    @Test
    //max max amount
    public void testMaxAmount() {
        Reward reward = new Reward();
        reward.setCategory(null);
        reward.setAmount(50);
        try {
            entityManager.persist(reward);
            entityManager.flush();
            fail("max amount");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }




}
