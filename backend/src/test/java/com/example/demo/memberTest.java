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
           assertEquals(violations.size(), 1);

       }
   }
   public void MembertestNullAddress() {
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
           System.out.println( "===================================================================================");
           System.out.println( e );
           System.out.println( "===================================================================================");
           System.out.println();
           System.out.println();
           System.out.println();

       }
   }
   public void MembertestNullNameM() {
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
       System.out.println( "===================================================================================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
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
       System.out.println( "===================================================================================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
public void MembertestNullPasswords() {
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
       System.out.println( "===================================================================================");
       System.out.println( e );
       System.out.println( "===================================================================================");
       System.out.println();
       System.out.println();
       System.out.println();

   }
}
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
            System.out.println("================================ Note Pattern is thai and 0-9 ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
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
            System.out.println("================FROM TypeDeletetestUnique ======================");
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
            System.out.println("================FROM TypeDeletetestUnique ======================");
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
            System.out.println("================FROM TypeDeletetestUnique ======================");
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


}
