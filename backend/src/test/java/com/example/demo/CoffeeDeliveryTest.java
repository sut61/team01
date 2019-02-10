package com.example.demo;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Status;
import com.example.demo.repository.CoffeeDeliveryRepository;
import com.example.demo.repository.DeliveryRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Set;
import javax.validation.*;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CoffeeDeliveryTest {
    @Autowired
    private CoffeeDeliveryRepository coffeedeliveryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void deliveryTest() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);


        try {
            entityManager.persist(d);
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

    @Test
    public void deliveryTestNameNull() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName(null);
        d.setPrice(100);

        try {
            entityManager.persist(d);
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
    public void deliveryTestPriceMin() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10);
        d.setStatusName("send");
        d.setStaffName("theerapol");


        try {
            entityManager.persist(d);
            entityManager.flush();

            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

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

    public void deliveryTestPattern() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("asfrwrgff000");


        try {
            entityManager.persist(d);
            entityManager.flush();

            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);

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


}
