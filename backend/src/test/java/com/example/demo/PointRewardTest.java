package com.example.demo;

import com.example.demo.entity.Point;
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



}
