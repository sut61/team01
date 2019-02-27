package com.example.demo;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Taste;
import com.example.demo.entity.Price;
import com.example.demo.entity.Vibe;
import com.example.demo.entity.Service;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TasteRepository;
import com.example.demo.repository.VibeRepository;

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
public class FeedbackTest {


    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private VibeRepository vibeRepository;

    @Autowired
    private TasteRepository tasteRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    
    @Autowired
    private PriceRepository priceRepository;

    
    @Autowired
    private TestEntityManager entityManager;


    private Validator validator;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //=======================================   SPRINT 2   ===========================================


    //========================================= Feedback Entity=======================================


    @Test
    //TEST PASSED DATA
    public void testPass() {
        Feedback feedback = new Feedback();
        feedback.setComment("Good Coffee");
        feedback.setOid("55");
        feedback.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        feedback.setService(serviceRepository.findByService("บริการดี"));
        feedback.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        feedback.setPrice(priceRepository.findByPrice("ราคาถูก"));
        try {
            entityManager.persist(feedback);
            entityManager.flush();
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
    // NOT NULL OID 
    public void testNotnullOid() {
        Feedback feedback = new Feedback();
        feedback.setComment("Good Coffee");
        feedback.setOid(null);
        feedback.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        feedback.setService(serviceRepository.findByService("บริการดี"));
        feedback.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        feedback.setPrice(priceRepository.findByPrice("ราคาถูก"));
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            fail("Success full");
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
    //MIN COMMENT
    public void testSizeMincomment() {
        Feedback feedback = new Feedback();
        feedback.setComment("GG");
        feedback.setOid(null);
        feedback.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        feedback.setService(serviceRepository.findByService("บริการดี"));
        feedback.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        feedback.setPrice(priceRepository.findByPrice("ราคาถูก"));
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            fail("Please more comment");
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

    //MAX COMMENT
    public void testSizMaxcomment() {
        Feedback feedback = new Feedback();
        feedback.setComment("COFFEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        feedback.setOid(null);
        feedback.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        feedback.setService(serviceRepository.findByService("บริการดี"));
        feedback.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        feedback.setPrice(priceRepository.findByPrice("ราคาถูก"));
        try {
            entityManager.persist(feedback);
            entityManager.flush();
            fail("Over comment");
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
    // TEST PATTERN OID
    public void testPatternOID() {
        Feedback fb1 = new Feedback();
        fb1.setComment("GOOD COFFEE");
        fb1.setOid("5556");
        fb1.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        fb1.setService(serviceRepository.findByService("บริการดี"));
        fb1.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        fb1.setPrice(priceRepository.findByPrice("ราคาถูก"));

        try {
            entityManager.persist(fb1);
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
    // TEST UNI OID
    public void testUniqueOID() {
        Feedback fb1 = new Feedback();
        Feedback fb2 = new Feedback();

        fb1.setComment("GOOD COFFEE");
        fb1.setOid("56");
        fb1.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        fb1.setService(serviceRepository.findByService("บริการดี"));
        fb1.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        fb1.setPrice(priceRepository.findByPrice("ราคาถูก"));


        fb2.setComment("GOOD COFFEE EIEI");
        fb2.setOid("56");
        fb2.setTaste(tasteRepository.findByTaste("รสชาติดีมาก"));
        fb2.setService(serviceRepository.findByService("บริการดี"));
        fb2.setVibe(vibeRepository.findByVibe("บรรยากาศดีเยี่ยม"));
        fb2.setPrice(priceRepository.findByPrice("ราคาถูก"));

        try {
            entityManager.persist(fb1);
            entityManager.flush();
            entityManager.persist(fb2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
         System.out.println(" ============================================ "+e+"Unique Error  ============================================");
        }
    }


}
