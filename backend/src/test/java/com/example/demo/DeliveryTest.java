package com.example.demo;

import com.example.demo.entity.CoffeeDelivery;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Staff;
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
public class DeliveryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private CoffeeDeliveryRepository coffeeDeliveryRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public  void setDataTest(){
        Status status1 = new Status();
        status1.setStatusName("Sent");
        Staff staff1 = new Staff();
        staff1.setStaffName("คนดีศรีกาแฟ");
        CoffeeDelivery coffeeDelivery1 = new CoffeeDelivery();
        coffeeDelivery1.setLongitude(111.222);
        coffeeDelivery1.setLatitude(14.555);


    }


    //Test ผ่าน
    @Test
    public void deliveryTest() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));


        try {
            entityManager.persist(d);
            //entityManager.flush();

            System.out.println( "===================================================================================");
            System.out.println("Test Successfully");
            System.out.println( "===================================================================================");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    //Test Null ของ Name
    @Test
    public void deliveryTestNameNull() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName(null);
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

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
            System.out.println( "==================== deliveryTestNameNull =========================");
            System.out.println( e );
            System.out.println( "===================== deliveryTestNameNull =========================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }

    @Test
    public void deliveryTestStaffNameNull() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("Coffee");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName(null);
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));
        try {
            entityManager.persist(d);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);


            System.out.println( "============================ deliveryTestStaffNameNull =============================");
            System.out.println( e );
            System.out.println( "============================= deliveryTestStaffNameNull ============================");


        }
    }



    //Test Min ของ Price
    @Test
    public void deliveryTestPriceMin() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

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
            System.out.println( "============================= deliveryTestPriceMin ===============================");
            System.out.println( e );
            System.out.println( "============================== deliveryTestPriceMin ==============================");
            System.out.println();
            System.out.println();
            System.out.println();

        }
    }

    @Test
    public void deliveryTestLatitudeMin() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(13.89);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "======================== deliveryTestLatitudeMin =============================");
            System.out.println( e );
            System.out.println( "===================================================================================");

        }
    }

    @Test
    public void deliveryTestLongitudeMin() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(99.999);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();

            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println( "============================= deliveryTestLongitudeMin ===========================");
            System.out.println( e );
            System.out.println( "===================================================================================");


        }
    }


    //Test Max ของ Price
    @Test
    public void deliveryTestPriceMax() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10000000);
        d.setStatusName("send");
        d.setStaffName("theerapol");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));
        try {
            entityManager.persist(d);
            entityManager.flush();
            entityManager.getEntityManager();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println( "============================ deliveryTestPriceMax ===============================");
            System.out.println( e );
            System.out.println( "============================= deliveryTestPriceMax =================================");

        }
    }

    public void deliveryTestPattern() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("asfrwrgff000");
        d.setStatus(statusRepository.findBystatusId(1l));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
          //  assertEquals(violations.size(), 1);

            System.out.println( "=================================== deliveryTestPattern ===========================");
            System.out.println( e );
            System.out.println( "===================================================================================");

        }
    }

    @Test
    public void deliveryTestStatus() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("coffee");
        d.setStatus(null);
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //  assertEquals(violations.size(), 1);

            System.out.println( "=================================== deliveryTestStatus ===========================");
            System.out.println( e );
            System.out.println( "===================================================================================");

        }
    }

    @Test
    public void deliveryTestStaff() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("coffee");
        d.setStatus(statusRepository.findBystatusId(1L));
        d.setStaff(null);
        d.setCoffeeDelivery(coffeeDeliveryRepository.getOne(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //  assertEquals(violations.size(), 1);

            System.out.println( "=================================== deliveryTestStaff ===========================");
            System.out.println( e );
            System.out.println( "===================================================================================");

        }
    }

    @Test
    public void deliveryTestCoffeeDelivery() {
        setDataTest();
        Delivery d = new Delivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100);
        d.setStatusName("send");
        d.setStaffName("coffee");
        d.setStatus(statusRepository.findBystatusId(1L));
        d.setStaff(staffRepository.getOne(1L));
        d.setCoffeeDelivery(null);


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //  assertEquals(violations.size(), 1);

            System.out.println( "============================= deliveryTestCoffeeDelivery ===========================");
            System.out.println( e );
            System.out.println( "===================================================================================");

        }
    }



}
