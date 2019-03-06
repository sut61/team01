package com.example.demo;

import com.example.demo.entity.Addpoint;
import com.example.demo.entity.Point;
import com.example.demo.entity.Reward;
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

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PointRewardTest {

    @Autowired
    private PointRepository pointRepository;
    @Autowired private RewardRepository rewardRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private AddpointRepository addpointRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    Point point = new Point();
    Reward reward = new Reward();
//    //============================================================================================
//    //******************************************SPRINT 2******************************************
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=========================================Reward Entity======================================

@Test public void keepError(){} //event not method to @Test it Error

    @Test
    public void SUCCESSsp2(){
        reward.setCategory("Oh na na na");
        reward.setAmount(500);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testNull(){
    reward.setCategory(null);
    reward.setAmount(500);
    reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
    reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
    try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
        System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
        System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
        System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testAmountMax(){
        reward.setCategory(null);
        reward.setAmount(50000);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));

        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testAmountPositive(){
        reward.setCategory(null);
        reward.setAmount(-5);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }
    @Test
    public void testAmountMin(){
        reward.setCategory(null);
        reward.setAmount(1);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testCatagoryPattern(){
        reward.setCategory("123456");
        reward.setAmount(100);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testSP2SizeMin(){
        reward.setCategory("G");
        reward.setAmount(100);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }
    @Test
    public void testSP2SizeMax(){
        reward.setCategory("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        reward.setAmount(100);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }



    //============================================================================================
    //******************************************SPRINT 1******************************************
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
    //=========================================Point Entity=======================================
    
    @Test
    public void SUCCESS(){
        point.setDate(new Date(2018-01-01));
    point.setOther("GOOD");
    point.setPointNumber(20);
    point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
    // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));
        try {
            entityManager.persist(point);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testSizeMax(){
        point.setDate(new Date(2018-01-01));
        point.setOther("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        point.setPointNumber(20);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));

//         Staff staff = new Staff();
//         staff.setStaffName("admin");
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testSizeMin(){
        point.setDate(new Date(2018-01-01));
        point.setOther("A");
        point.setPointNumber(20);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));

        
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }



    @Test
    public void testTPattern(){
        point.setDate(new Date(2018-01-01));
        point.setOther("123456789");
        point.setPointNumber(20);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));

        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testPositivePoint(){
        point.setDate(new Date(2018-01-01));
        point.setOther("GOOD");
        point.setPointNumber(-5);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));

        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }
  
    @Test
    public void testMaxPoint(){
        point.setDate(new Date(2018-01-01));
        point.setOther("GOOD");
        point.setPointNumber(1);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));

        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testMinPoint(){
        point.setDate(new Date(2018-01-01));
        point.setOther("GOOD");
        point.setPointNumber(5000);
        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        // point.setStaff(staffRepository.getOne(1L));
point.setStaff(staffRepository.findByUsername("Oh na na na"));
point.setAddpoint(addpointRepository.getOne(2L));


        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

}
