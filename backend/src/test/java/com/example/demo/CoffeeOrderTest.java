package com.example.demo;

import com.example.demo.entity.CoffeeOrder;
import com.example.demo.entity.OrderType;
import com.example.demo.entity.Member;
import com.example.demo.entity.CoffeeMenu;
import com.example.demo.entity.Staff;
import com.example.demo.entity.*;
import com.example.demo.repository.CoffeeMenuRepository;
import com.example.demo.repository.CoffeeOrderRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrderTypeRepository;
import com.example.demo.repository.StaffRepository;
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
public class CoffeeOrderTest {


    @Autowired
    private CoffeeMenuRepository coffeeMenuRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @Autowired
    private TestEntityManager entityManager;

    

    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //=======================================   SPRINT 1  ===========================================


    //========================================= CoffeeOrder Entity=======================================

  
    @Test
    //TEST PASSED DATA
    public void testDataPass() {
        CoffeeOrder coffeeorder = new CoffeeOrder();
        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("MAWMEAW EIEI"));
        coffeeorder.setTotalPrice(250);
        coffeeorder.setQuantity(3);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));
        
        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.println("============================================================================================================================================");
            e.printStackTrace();
            System.out.println("============================================================================================================================================");
            System.out.println(e);
            System.out.println("============================================================================================================================================");
        }
    }

    @Test
    // TEST UNI PRICE
    public void testUniquePRICE() {

        CoffeeOrder coffeeorder = new CoffeeOrder();
        CoffeeOrder coffeeorder2 = new CoffeeOrder();

        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("MAWMEAW EIEI"));
        coffeeorder.setTotalPrice(250);
        coffeeorder.setQuantity(3);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));


        coffeeorder2.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder2.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder2.setStaff(staffRepository.findByUsername("MAWMEAW EIEI"));
        coffeeorder2.setTotalPrice(250);
        coffeeorder2.setQuantity(3);
        coffeeorder2.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));

        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();
            entityManager.persist(coffeeorder2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
         System.out.println(" ============================================ "+e+"Unique Error  ============================================");
        }
    }



    @Test
     // // TEST CoffeeQuantityMax 
    public void CoffeeQuantityMax() {
        CoffeeOrder coffeeorder = new CoffeeOrder();
        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("MAWMEAW EIEI"));
        coffeeorder.setTotalPrice(250);
        coffeeorder.setQuantity(100);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));

        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "================================ CoffeeQuantityMax ================================");
            System.out.println( e );
            System.out.println( "================================ CoffeeQuantityMax ================================");

        }
    }

    @Test
      // // TEST CoffeeQuantityMin 
    public void CoffeeQuantityMin() {
        CoffeeOrder coffeeorder = new CoffeeOrder();
        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("MAWMEAW EIEI"));
        coffeeorder.setTotalPrice(250);
        coffeeorder.setQuantity(0);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));

        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "================================ CoffeeQuantityMin ================================");
            System.out.println( e );
            System.out.println( "================================ CoffeeQuantityMin ================================");

        }
    }



    
    @Test
    // TEST Size STAFFNAME
    public void testSizeSTAFFNAME() {
        CoffeeOrder coffeeorder = new CoffeeOrder();
        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("A"));
        coffeeorder.setTotalPrice(2000);
        coffeeorder.setQuantity(0);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes("Dine-In"));

        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    // TEST NOTNULL ORDER TYPE
    public void testNotnullOrdertype() {
        CoffeeOrder coffeeorder = new CoffeeOrder();
        coffeeorder.setCoffeeMenu(coffeeMenuRepository.findByItemName("Late"));
        coffeeorder.setMember(memberRepository.findByUser("Kongtahong Menawun"));
        coffeeorder.setStaff(staffRepository.findByUsername("A"));
        coffeeorder.setTotalPrice(2000);
        coffeeorder.setQuantity(0);
        coffeeorder.setOrderType(orderTypeRepository.findByOrderTypes(null));

        try {
            entityManager.persist(coffeeorder);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("-------------------------------"+violations+"--------------------------");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}