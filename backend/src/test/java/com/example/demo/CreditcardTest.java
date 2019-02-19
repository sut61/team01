package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.CreditcardpaymentRepository;
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
import javax.validation.constraints.Null;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreditcardTest {


    @Autowired
    private CreditcardpaymentRepository creditcardpaymentRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

   //------------------------Sprint2-----------------------------------//

    @Test
    //test null date
    public void testExpireddateCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setExpireddate(null);
        creditcardpayment.setMoney(20);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("date is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Expired Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    //min creditname
    public void testSizeMinCreditname() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("P");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditname too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Creditnameminsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }
    }

    @Test
    //max creditname
    public void testSizeMaxCreditname() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditname too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Creditnamemaxsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //pattern creditname
    public void testPatternCreditname() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("นภัส");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditname too ACSII");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ CreditnamePattern ASCII ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //not null money
    public void testMoneyCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(null);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Money is Null");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Money Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //not null money
    public void testCreditnumberCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20);
        creditcardpayment.setCreditnumber(null);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditnumber is Null");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Creditnumber Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }
    }

    @Test
    //not null money
    public void testCscCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(null);
        creditcardpayment.setMoney(20);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Csc is Null");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Csc Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

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
       // entityManager.flush();

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
    public void testCredittypeUnique() {
        Credittype credittype = new Credittype();
        credittype.setTypename("JJB");
        entityManager.persist(credittype);
        entityManager.flush();

        Credittype credittype1 = new Credittype();
        credittype1.setTypename("JJB");

        try{
            entityManager.persist(credittype1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================Credittype is Notnull ======================");
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
}
