package com.example.demo;

import com.example.demo.entity.Cancel;
import com.example.demo.repository.CancelRepository;
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
public class CancelMemberTest {

    @Autowired
    private CancelRepository cancelRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //============================================================================================
    //******************************************SPRINT 2******************************************
    //=========================================Cancel Entity=======================================


    @Test
    //test null date
    public void testNullReason() {
        Cancel cancel = new Cancel();
        cancel.setReason(null);
        cancel.setNote(null);
        cancel.setDate(null);
        // cancel.setStaff("null");
        // cancel.setTypeDelete("null");
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            // assertEquals(violations.size(), 1);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }
    @Test
    // no fail
    public void testNotnullReason() {
        Cancel cancel = new Cancel();
        cancel.setReason("not error");
        cancel.setNote("not error");
        //cancel.setDate(null);
        try {
            entityManager.persist(cancel);
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
    //min reason
    public void testSizeMinReason() {
        Cancel cancel = new Cancel();
        cancel.setReason("Not erroe");
        cancel.setNote("not error");
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("too less character");
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
    public void testSizMaxReason() {
        Cancel cancel = new Cancel();
        cancel.setReason("PASS");
        cancel.setNote("pass");
        cancel.setDate(null);
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("too less character");
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
