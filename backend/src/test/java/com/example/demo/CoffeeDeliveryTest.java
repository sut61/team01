package com.example.demo;
import com.example.demo.entity.CoffeeDelivery;
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
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void CoffeeDeliveryTest() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);


        try {
            entityManager.persist(d);
            entityManager.flush();

            System.out.println( "===================================================================================");
            System.out.println("CoffeeDeliveryTestPass");
            System.out.println( "===================================================================================");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void CoffeeDeliveryTestNameNull() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName(null);
        d.setPrice(100);

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "================================ CoffeeDeliveryTestNameNull ============================");
            System.out.println( e );
            System.out.println( "===============================  CoffeeDeliveryTestNameNull ============================");

        }
    }

    @Test
    public void CoffeeDeliveryTestPriceMin() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10);

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "================================ CoffeeDeliveryTestPriceMin ================================");
            System.out.println( e );
            System.out.println( "================================ CoffeeDeliveryTestPriceMin ================================");
        }
    }


    @Test
    public void CoffeeDeliveryTestPriceMax() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(3000);

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "================================ CoffeeDeliveryTestPriceMax ================================");
            System.out.println( e );
            System.out.println( "================================ CoffeeDeliveryTestPriceMax ================================");

        }
    }

    @Test
    public void CoffeeDeliveryTestLongitudeMin() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(99.999);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);


        try {
            entityManager.persist(d);
            entityManager.flush();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println( "============================= CoffeeDeliveryTestLongitudeMin ===========================");
            System.out.println( e );
            System.out.println( "==========================================|||============================================");


        }
    }

    @Test
    public void CoffeeDeliveryTestLatitudeMin() {
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(115.2);
        d.setLatitude(13.99);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);


        try {
            entityManager.persist(d);
            entityManager.flush();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println( "============================= CoffeeDeliveryTestLatitudeMin ===========================");
            System.out.println( e );
            System.out.println( "==========================================|||============================================");


        }
    }




}
