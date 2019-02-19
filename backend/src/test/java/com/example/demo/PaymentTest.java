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
        payment.setMoney(20);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("note is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Note Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    //min note
    public void testSizeMinNote() {
        Payment payment = new Payment();
        payment.setNote("O");
        payment.setMoney(20);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Noteminsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    //max note
    public void testSizeMaxNote() {
        Payment payment = new Payment();
        payment.setNote("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        payment.setMoney(20);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Notemaxsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }
    }

    @Test
    //pattern note
    public void testPatternNote() {
        Payment payment = new Payment();
        payment.setNote("napat");
        payment.setMoney(20);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Note pattern is ascii");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Note Pattern is thai and 0-9 ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    //test null
    public void testMoneyCannotNull() {
        Payment payment = new Payment();
        payment.setNote("ไม่มี");
        payment.setMoney(null);
        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("money is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Money Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    @Test
    public void testStaffUnique() {
        Staff s = new Staff();
        s.setStaffName("นภัสวรรณ");
        entityManager.persist(s);
        entityManager.flush();

        Staff s1 = new Staff();
        s1.setStaffName("นภัสวรรณ");

        try{
            entityManager.persist(s1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================Staff is Notnull ======================");
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
    public void testMemberUnique() {
        Member m = new Member();
        m.setNameM("1234");
        entityManager.persist(m);
       //entityManager.flush();

        Member m1 = new Member();
        m1.setNameM("1234");

        try{
            entityManager.persist(m1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================Member is Notnull ======================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("==================================================================");
            e.printStackTrace();
        }
    }

    @Test
    public void testCoffeeorderUnique() {
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setOrderid(Long.valueOf(100000000));
        //entityManager.persist(coffeeOrder);
        entityManager.flush();

        CoffeeOrder c1 = new CoffeeOrder();
        c1.setOrderid(Long.valueOf(100000000));

        try {
            entityManager.persist(c1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================coffeeorder is Notnull ======================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        } catch (javax.persistence.PersistenceException e) {
            System.out.println("==================================================================");
            e.printStackTrace();
        }

    }
}
