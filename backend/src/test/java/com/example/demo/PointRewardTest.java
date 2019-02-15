package com.example.demo;

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
            assertEquals(violations.size(), 2);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }





    @Test
    public void SUCCESSspTTT(){
        reward.setCategory("Oh na na na");
        reward.setAmount(500);
        reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
        reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
        //     review.setNewHotelEntity(hotelRepository.findByhotelNameEng("PhimaiIn"))
        try {
            entityManager.persist(point);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }
//     review.setNewHotelEntity(hotelRepository.findByhotelNameEng("PhimaiIn"));
//        review.setNewReservationRoomEntity(reservationRepository.findRservationById(1L));
//        review.setNewRoomTypeEntity(roomTypeRepository.findByName("Standard"));

    @Test
    public void testNull(){
    reward.setCategory(null);
    reward.setAmount(500);
    reward.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
    reward.setStaff(staffRepository.findByUsername("Baby pood pood!"));
//    point.setDate(new Date());
    try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
//    point.setDate(new Date());
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
//    point.setDate(new Date());
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
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
//        reward.setCategory(null);
//        reward.setAmount(-5);

    point.setDate(null);
    point.setOther("GOOD");
        try {
            entityManager.persist(point);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testSizeMax(){
//        reward.setCategory(null);
//        reward.setAmount(-5);

        point.setDate(null);
        point.setOther("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

//point.setAddpoint(addpointRepository.findByAddpoint("1"));
//        point.setMember(memberRepository.findByUser("ลิช่า มาเร็ว"));
//        point.setStaff(staffRepository.findByUsername("Baby pood pood!"));


        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }

    @Test
    public void testSizeMin(){
//        reward.setCategory(null);
//        reward.setAmount(-5);

        point.setDate(null);
        point.setOther("A");
        try {
            entityManager.persist(point);
            entityManager.flush();
            fail("==== have some this line fail ====");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            e.printStackTrace();
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
            System.out.println(e);
            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
        }
    }


//    @Test
//    public void testAddpoint(){
//
//        point.setDate(null);
//        point.setOther("A");
//        try {
//            entityManager.persist(point);
//            entityManager.flush();
//            fail("==== have some this line fail ====");
//
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 2);
//            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
//            e.printStackTrace();
//            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
//            System.out.println(e);
//            System.out.println("!@#$%^&*()_+_)(*&^%$#@!@#$%^&*()_+_)(*&^%$#@!");
//        }
//    }

//    review.setNewHotelEntity(hotelRepository.findByhotelNameEng("PhimaiIn"));
//    review.setNewReservationRoomEntity(reservationRepository.findRservationById(1L));
//    review.setNewRoomTypeEntity(roomTypeRepository.findByName("Standard"));





















//    @Test
//    //test null date
//    public void testNullOther() {
//        Point point = new Point();
//        point.setOther(null);
//        point.setDate(null);
//        try {
//            entityManager.persist(point);
//            entityManager.flush();
//            fail("other is null");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//    @Test
//    // no fail
//    public void testNotnullOther() {
//        Point point = new Point();
//        point.setOther("Good Other");
//        point.setDate(null);
//        try {
//            entityManager.persist(point);
//            entityManager.flush();
//            fail("Success full");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//    @Test
//    //min other
//    public void testSizeMinother() {
//        Point point = new Point();
//        point.setOther("GG");
//        point.setDate(null);
//        try {
//            entityManager.persist(point);
//            entityManager.flush();
//            fail("other too less character");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//    @Test
//    //max other
//    public void testSizMaxeother() {
//        Point point = new Point();
//        point.setOther("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//        point.setDate(null);
//        try {
//            entityManager.persist(point);
//            entityManager.flush();
//            fail("other too less character");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//
//
//
//    //============================================================================================
//    //******************************************SPRINT 2******************************************
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=
//    //=========================================Reward Entity======================================
//
//
//
//
//
//    @Test
//    //Don't fail
//    public void testGoodAmount() {
//        Reward reward = new Reward();
//        reward.setCategory("Oh na na na");
//        reward.setAmount(1);
//        try {
//            entityManager.persist(reward);
//            entityManager.flush();
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//
//
//    @Test
//    //max max category
//    public void testMaxCategory() {
//        Reward reward = new Reward();
//        reward.setCategory("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
//        reward.setAmount(1);
//        try {
//            entityManager.persist(reward);
//            entityManager.flush();
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//
//    @Test
//    //max min category
//    public void testMinCategory() {
//        Reward reward = new Reward();
//        reward.setCategory("WW");
//        reward.setAmount(1);
//        try {
//            entityManager.persist(reward);
//            entityManager.flush();
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//    @Test
//    //max null category
//    public void testAmountNegative() {
//        Reward reward = new Reward();
//        reward.setCategory(null);
//        reward.setAmount(1);
//        try {
//            entityManager.persist(reward);
//            entityManager.flush();
//            fail("category null");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }
//
//    @Test
//    //max max amount
//    public void testMaxAmount() {
//        Reward reward = new Reward();
//        reward.setCategory(null);
//        reward.setAmount(50);
//        try {
//            entityManager.persist(reward);
//            entityManager.flush();
//            fail("max amount");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//            System.out.println("============================================================================================================================================");
//            e.printStackTrace();
//            System.out.println("============================================================================================================================================");
//            System.out.println(e);
//            System.out.println("============================================================================================================================================");
//        }
//    }




}
