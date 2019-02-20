package com.example.demo;

import com.example.demo.entity.Status;
import com.example.demo.repository.StatusRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.net.ssl.SSLEngineResult;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StatusTest {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void  setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //Test ผ่าน
    @Test
    public  void StatusTestPass(){
        Status s = new Status();
        s.setStatusName("Sent");

        try {
            entityManager.persist(s);
            entityManager.flush();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println( "===================================================================================");
            System.out.println("Test Successfully");
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

    //Test  Null
    @Test
    public  void StatusTestNull(){
        Status s = new Status();
        s.setStatusName(null);

        try {
            entityManager.persist(s);
            entityManager.flush();



            fail("Error this line >>>");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println("=============================== StatusTestNull ===============================");
            System.out.println(e);
            System.out.println("=============================== StatusTestNull ===============================");

        }

    }
}
