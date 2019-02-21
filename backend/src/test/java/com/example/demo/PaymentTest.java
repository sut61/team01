package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.CreditcardpaymentRepository;
import com.example.demo.repository.PaymentRepository;
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
public class PaymentTest {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

   //------------------------Sprint1-----------------------------------//

    @Test
    //test null
    public void testNoteCannotNull() {
        Payment payment = new Payment();
        payment.setNote(null);
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("note is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Note Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    //min note
    public void testSizeMinNote() {
        Payment payment = new Payment();
        payment.setNote("O");
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Noteminsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }
    }

    @Test
    //max note
    public void testSizeMaxNote() {
        Payment payment = new Payment();
        payment.setNote("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Notemaxsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //pattern note
    public void testPatternNote() {
        Payment payment = new Payment();
        payment.setNote("napat");
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note pattern is ascii");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Note Pattern is thai and 0-9 ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }
    }

    @Test
    //test null
    public void testCashCannotNull() {
        Payment payment = new Payment();
        payment.setNote("ไม่มี");
        payment.setCash(null);
        payment.setChange(20);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("cash is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Cash Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    //test null
    public void testChangeCannotNull() {
        Payment payment = new Payment();
        payment.setNote("ไม่มี");
        payment.setCash(100);
        payment.setChange(null);
        payment.setDiscount(10);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("change is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Change Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    //test null
    public void testDiscountCannotNull() {
        Payment payment = new Payment();
        payment.setNote("ไม่มี");
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(null);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Discount is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Discount Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    //test null
    public void testDateCannotNull() {
        Payment payment = new Payment();
        payment.setNote("ไม่มี");
        payment.setCash(100);
        payment.setChange(20);
        payment.setDiscount(20);
        payment.setDate(null);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Date is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ date Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
