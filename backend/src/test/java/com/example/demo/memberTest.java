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
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class memberTest {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

   //------------------------Sprint1-----------------------------------//
//TEST1

   @Test
   public void MembertestSuccess() {
       Member member = new Member();
       member.setPassword("1234");
       member.setNameM("lisa malaw");
       member.setAddress("address");
       member.setUser("user");
       try {
           entityManager.persist(member);
           entityManager.flush();

           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println( "===================================================================================");
           System.out.println("Test Successful");
           System.out.println( "===================================================================================");
           System.out.println();
           System.out.println();
           System.out.println();

       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           

       }
   }
//TEST2
   @Test
   public void MembertestNullAndNotBlankAddress() {
        Member member = new Member();
        member.setPassword("1234");
        member.setNameM("lisa malaw");
        member.setAddress(null);
        member.setUser("user");
        try {
            entityManager.persist(member);
            entityManager.flush();
            entityManager.getEntityManager();

           fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);

           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println( "================================NullAndNotBlankAddress=============================");
           System.out.println( e );
           System.out.println( "===================================================================================");
           System.out.println();
           System.out.println();
           System.out.println();

       }
   }
//TEST3
   @Test
   public void MembertestNullAndNotBlankNameM() {
    Member member = new Member();
    member.setPassword("1234");
    member.setNameM(null);
    member.setAddress("address");
    member.setUser("user");
    try {
        entityManager.persist(member);
        entityManager.flush();
        entityManager.getEntityManager();

       fail("Should not pass to this line");
   } catch(javax.validation.ConstraintViolationException e) {
       Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
       assertEquals(violations.isEmpty(), false);

       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println( "================================NullAndNotBlankNameM===============================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
//TEST4
@Test
public void MembertestNullUser() {
    Member member = new Member();
    member.setPassword("1234");
    member.setNameM("lisa malaw");
    member.setAddress("address");
    member.setUser(null);
    try {
        entityManager.persist(member);
        entityManager.flush();
        entityManager.getEntityManager();

       fail("Should not pass to this line");
   } catch(javax.validation.ConstraintViolationException e) {
       Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
       assertEquals(violations.isEmpty(), false);

       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println( "======================================NullUser====================================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
//TEST5
@Test
public void MembertestNullAndNotBlankPasswords() {
    Member member = new Member();
    member.setPassword(null);
    member.setNameM("lisa malaw");
    member.setAddress("address");
    member.setUser("user");
    try {
        entityManager.persist(member);
        entityManager.flush();
        entityManager.getEntityManager();

       fail("Should not pass to this line");
   } catch(javax.validation.ConstraintViolationException e) {
       Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
       assertEquals(violations.isEmpty(), false);

       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println( "===============================NullAndNotBlankPasswords============================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
//TEST6
    @Test
    //pattern 
    public void testPatternUser() {
        Member member = new Member();
        member.setUser("1namphon");
        member.setAddress(null);
        member.setNameM("Alis");
        member.setPassword("1234");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("Note pattern is ascii");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("==================================== Note Pattern is thai and 0-9 ===============================");
            System.out.println(e.getConstraintViolations());
            System.out.println("==================================================================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            
        }
    }
//TEST7
    @Test
    //Length 
    public void testLengthPassword() {
        Member member = new Member();
        member.setUser("1namphon");
        member.setAddress("77/8");
        member.setNameM("Alis");
        member.setPassword("12345678901");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("Password Length is error");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================================= Password Length is error ===============================");
            System.out.println(e.getConstraintViolations());
            System.out.println("==================================================================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            
        }
    }
//TEST8
    @Test
    public void ProvincetestUnique() {
        Province province = new Province();
        province.setNamePa("province");
        entityManager.persist(province);
        entityManager.flush();

        Province province1 = new Province();
        province1.setNamePa("province?");

        try{
            entityManager.persist(province1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("==================================FROM TypeDeletetestUnique ====================================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("================================================================================================");
            e.printStackTrace();
        }
    }
//TEST9
    @Test
    public void NametypetestUnique() {
        Nametype nametype = new Nametype();
        nametype.setNameDoc("nameType");
        entityManager.persist(nametype);
        entityManager.flush();

        Nametype nametype1 = new Nametype();
        nametype1.setNameDoc("nameType");

        try{
            entityManager.persist(nametype1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("=================================FROM TypeDeletetestUnique =====================================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("================================================================================================");
            e.printStackTrace();
        }
    }
//TEST10
    @Test
    public void GendertestUnique() {
        Gender gender = new Gender();
        gender.setGender("sex");
        entityManager.persist(gender);
        entityManager.flush();

        Gender gender1 = new Gender();
        gender1.setGender("sex");

        try{
            entityManager.persist(gender1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================= FROM TypeDeletetestUnique ====================================");
            e.printStackTrace();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        catch (javax.persistence.PersistenceException e){
            System.out.println("================================================================================================");
            e.printStackTrace();
        }
    }
//TEST11
//TEST Unique
    @Test
	public void testUniqueUser(){
		Member member = new Member();
        member.setUser("1namphon");
        member.setAddress("77/8");
        member.setNameM("Alis");
        member.setPassword("12345678901");
        Member member2 = new Member();
        member2.setUser("1namphon");
        
        try {
            entityManager.persist(member2);
            entityManager.flush();
            fail("Unique is error");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("========================================= Unique is error ===============================");
            System.out.println(e.getConstraintViolations());
            System.out.println("==================================================================================================");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            
        }
    }

}
