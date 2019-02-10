package com.example.demo;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TasteRepository;
import com.example.demo.repository.VibeRepository;

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
public class FeedbackTest {


    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private VibeRepository vibeRepository;

    @Autowired
    private TasteRepository tasteRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    
    @Autowired
    private PriceRepository priceRepository;

    
    @Autowired
    private TestEntityManager entityManager;


    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //=======================================   SPRINT 2   ===========================================


    //========================================= Feedback Entity=======================================


    @Test
    //test not null
    public void testPass() {
        Feedback feedback = new Feedback();
        feedback.setComment("Good Coffee");
        feedback.setOid("55");
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            // fail("other is null");
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
    // null oid fail
    public void testNotnullOid() {
        Feedback feedback = new Feedback();
        feedback.setComment("Good Coffee");
        feedback.setOid(null);
        try {
            entityManager.persist(feedback);
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
    //min comment
    public void testSizeMincomment() {
        Feedback feedback = new Feedback();
        feedback.setComment("GG");
        feedback.setOid(null);
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            fail("Please more comment");
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
    //max comment
    public void testSizMaxcomment() {
        Feedback feedback = new Feedback();
        feedback.setComment("COFFEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        feedback.setOid(null);
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            fail("Over comment");
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
