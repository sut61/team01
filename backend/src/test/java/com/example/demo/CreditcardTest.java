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
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreditcardTest {


    @Autowired
    private CreditcardpaymentRepository creditcardpaymentRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CoffeeOrderRepository coffeeorderRepository;
    @Autowired
    private CredittypeRepository credittypeRepository;

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
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("date is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Expired Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    //min creditname
    public void testSizeMinCreditname() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("P");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditname too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Creditnameminsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //max creditname
    public void testSizeMaxCreditname() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
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
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
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
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
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
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setCreditnumber(null);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
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
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
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
    //not null
    public void testDiscountCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(null);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Discount is Null");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Discount Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    //not null
    public void testCreditnameCannotNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname(null);
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Creditname is Null");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Creditname Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    public void testMemberNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(null);
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Member cannot null --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testStaffNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(null);
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Staff cannot null --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testCredittypeNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(null);
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Credittype cannot null --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testCoffeeorderNull() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(20.0);
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCoffeeorder(null);
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Coffeeorder cannot null --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testMinDiscount() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(0.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Min Discount --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testMaxDiscount() {
        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname("napat");
        creditcardpayment.setCsc(623);
        creditcardpayment.setMoney(20.0);
        creditcardpayment.setDiscount(550.0);
        creditcardpayment.setExpireddate(new Date(02-02-2018));
        creditcardpayment.setMember(memberRepository.findById(1L).get());
        creditcardpayment.setStaff(staffRepository.findById(1L).get());
        creditcardpayment.setCredittype(credittypeRepository.findById(1L).get());
        try {
            entityManager.persist(creditcardpayment);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("------------------------------- Max Discount --------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }



}