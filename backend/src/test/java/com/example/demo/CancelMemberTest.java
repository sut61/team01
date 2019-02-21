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
        cancel.setUserDeleted(null);
        cancel.setNote(null);
        cancel.setDate(null);
        
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("is null");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
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
        cancel.setUserDeleted("not error");
        cancel.setNote("not error");
       
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("Success full");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
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
        cancel.setUserDeleted("PASS");
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
    @Test
    public void CanceltestPatternNote() {
        Cancel cancel = new Cancel();
        cancel.setNote("0.0!");
        cancel.setUserDeleted("user");
        try {
            entityManager.persist(cancel);
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
    public void StafftestUnique() {
        Staff staff = new Staff();
        staff.setStaffName("admin");
        entityManager.persist(staff);
        entityManager.flush();

        Staff staff1 = new Staff();
        staff1.setStaffName("admin");

        try{
            entityManager.persist(staff1);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================FROM StafftestUnique ======================");
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
    public void TypeDeletetestUnique() {
        TypeDelete typeDelete = new TypeDelete();
        typeDelete.setTyptD("member?");
        entityManager.persist(typeDelete);
        entityManager.flush();

        TypeDelete typeDelete1 = new TypeDelete();
        typeDelete1.setTyptD("member?");

        try{
            entityManager.persist(typeDelete1);
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

