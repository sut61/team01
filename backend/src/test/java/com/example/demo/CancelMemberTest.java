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

//TEST1 notnull date    
    @Test
    public void testNullDate() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("user");
        cancel.setNote("deleted");
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
//TEST2 UserDeleted Notnull And NotBlank
    @Test
    public void testNullUserDeletedAndNotBlank () {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted(null);
        cancel.setNote("deleted");
        
        
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
//TEST3 UserDeleted no fail
    @Test
    public void testNotnullUserDeleted() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("user");
        cancel.setNote("deleted");
       
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("Success full");
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
    
//TEST4 NOTE Notnull And NotBlank
    @Test
    public void testNullNoteAndNotBlank() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("user");
        cancel.setNote(null);
        
        
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
//TEST5 NOTE no fail
    @Test
    public void testNotnullNote() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("user");
        cancel.setNote("deleted");
    
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("Success full");
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
//TEST SIZE NOTE
//TEST6 MAX NOTE
    @Test
    public void testSizMaxNote() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("PASS");
        cancel.setNote("pass5678901pass5678902pass5678903");
        cancel.setDate(null);
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("Note Size < 30");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Note Size Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            
        }
    }
//TEST7 MIN NOTE
    @Test
    public void testSizMinNote() {
        Cancel cancel = new Cancel();
        cancel.setUserDeleted("PASS");
        cancel.setNote("T");
        cancel.setDate(null);
        try {
            entityManager.persist(cancel);
            entityManager.flush();
            fail("Note Size > 2");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(" Note Size Error");
            System.out.println(e);
            System.out.println();

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            
        }
    }
//TEST8 Pattern Note
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
            System.out.println( "======================  PATTERN ERROR  ======================================");
            System.out.println( e );
            System.out.println( "===================================================================================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }
//TEST9 NULL STAFF
    @Test
    public void StafftestUnique() {
        Staff staff = new Staff();
        staff.setStaffName("admin");
        entityManager.persist(staff);
        entityManager.flush();

        Staff staff1 = new Staff();
        staff1.setStaffName(null);

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
//TEST10 NULL TYPEDELETE
    @Test
    public void TypeDeletetestUnique() {
        TypeDelete typeDelete = new TypeDelete();
        typeDelete.setTyptD("member?");
        entityManager.persist(typeDelete);
        entityManager.flush();

        TypeDelete typeDelete1 = new TypeDelete();
        typeDelete1.setTyptD(null);

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

