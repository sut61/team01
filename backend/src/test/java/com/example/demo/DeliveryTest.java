package com.example.demo;

import com.example.demo.entity.Delivery;
import com.example.demo.entity.Status;
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
public class DeliveryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

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


    //Test ผ่าน
    @Test
    public void deliveryTest() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("theerapol");

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

    //Test Null ของ Name
    @Test
    public void deliveryTestNameNull() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName(null);
        d.setPrice(100);
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
    public void deliveryTestStaffNameNull() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("Coffee");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName(null);

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

//    @Test
//    public void deliveryTestLongitudeNull() {
//        Delivery d = new Delivery();
//        d.setLongitude(111.222);
//        d.setLatitude(L);
//        d.setName("farm");
//        d.setPrice(100);
//        d.setStatusName("send");
//        d.setStaffName("theerapol");
//
//        try {
//            entityManager.persist(d);
//            entityManager.flush();
//            entityManager.getEntityManager();
//
//            fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println( "===================================================================================");
//            System.out.println( e );
//            System.out.println( "===================================================================================");
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        }
//    }
//


    //Test Min ของ Price
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

//    @Test
//    public void deliveryTestLatitudeMin() {
//        Delivery d = new Delivery();
//        d.setLongitude(111.222);
//        d.setLatitude(13.89);
//        d.setName("เอสเปรสโซ่");
//        d.setPrice(10);
//        d.setStatusName("send");
//        d.setStaffName("theerapol");
//
//
//        try {
//            entityManager.persist(d);
//            entityManager.flush();
//
//            entityManager.getEntityManager();
//
//            fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println( "===================================================================================");
//            System.out.println( e );
//            System.out.println( "===================================================================================");
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        }
//    }

//    @Test
//    public void deliveryTestLongitudeMin() {
//        Delivery d = new Delivery();
//        d.setLongitude(99.999);
//        d.setLatitude(14.555);
//        d.setName("เอสเปรสโซ่");
//        d.setPrice(10);
//        d.setStatusName("send");
//        d.setStaffName("theerapol");
//
//
//        try {
//            entityManager.persist(d);
//            entityManager.flush();
//
//            entityManager.getEntityManager();
//
//            fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(), 1);
//
//            System.out.println();
//            System.out.println();
//            System.out.println();
//            System.out.println( "===================================================================================");
//            System.out.println( e );
//            System.out.println( "===================================================================================");
//            System.out.println();
//            System.out.println();
//            System.out.println();
//
//        }
//    }


    //Test Max ของ Price
    @Test
    public void deliveryTestPriceMax() {
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10000000);
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


    @Test(expected=javax.persistence.PersistenceException.class)
    public void testIdMustBeUnique() {
        Delivery d1 = new Delivery();
        d1.setDeliveryId(Long.valueOf(1));
        d1.setLongitude(111.222);
        d1.setLatitude(14.555);
        d1.setName("เอสเปรสโซ่");
        d1.setPrice(100);
        d1.setStatusName("send");
        d1.setStaffName("theerapol");


        entityManager.persist(d1);
        entityManager.flush();

        Delivery d2 = new Delivery();
        d2.setDeliveryId(Long.valueOf(1));
        d2.setLongitude(155.22);
        d2.setLatitude(15.555);
        d2.setName("ลาเต้");
        d2.setPrice(150);
        d2.setStatusName("sending");
        d2.setStaffName("farm");



        entityManager.persist(d2);
        entityManager.flush();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println( "===================================================================================");
        System.out.println("Test Unique");
        System.out.println( "===================================================================================");
        System.out.println();
        System.out.println();
        System.out.println();


        fail("Should not pass to this line");
    }



}
