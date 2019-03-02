package com.example.demo;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
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
    private ManuRepository manuRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
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

    public void setData(){
        Manu manu1 = new Manu();
        manu1.setName("ลาเต้");
        ServiceType serviceType1 = new ServiceType();
        serviceType1.setService("Delivery");
        Member member1 = new Member();
        member1.setNameM("ลิซ่า มาเร็ว");



    }

    @Test
    public void CoffeeDeliveryTest() {
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));




        try {
            entityManager.persist(d);
            entityManager.flush();

            System.out.println( "===================================================================================");
            System.out.println("CoffeeDeliveryTestPass");
            System.out.println( "===================================================================================");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    @Test
    public void CoffeeDeliveryTestNameNull() {
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName(null);
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));

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
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(10.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));

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
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(3000.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));

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
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(99.999);
        d.setLatitude(14.555);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));


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
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(115.2);
        d.setLatitude(13.99);
        d.setName("เอสเปรสโซ่");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));


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

    @Test
    public  void  coffeeDeliveryTestNamePattern(){
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(115.2);
        d.setLatitude(14.00);
        d.setName("Name99");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));

        try {
            entityManager.persist(d);
            entityManager.flush();


            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            System.out.println( "============================= CoffeeDeliveryTestNamePattern ===========================");
            System.out.println( e );
            System.out.println( "==========================================|||==========================================");


        }

    }

    @Test
    public void CoffeeDeliveryTestMemberNull() {
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("aaa");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(null);

        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** CoffeeDeliveryTestMemberNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");

        }
    }
    @Test
    public void CoffeeDeliveryTestServiceTypeNull() {
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("aaa");
        d.setPrice(100.0);
        d.setManuid(manuRepository.findByManuid(1));
        d.setServiceType(null);
        d.setMember(memberRepository.findByMeid(1L));


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println( "=========********** CoffeeDeliveryTestServiceTypeNull ********=============");
            System.out.println( e );
            System.out.println( "=========********** CoffeeDeliveryTestServiceTypeNull ********=============");
            System.out.println();
        }
    }
    @Test
    public void CoffeeDeliveryTestManuNull() {
        setData();
        CoffeeDelivery d = new CoffeeDelivery();
        d.setLongitude(111.222);
        d.setLatitude(14.555);
        d.setName("aaa");
        d.setPrice(100.0);
        d.setManuid(null);
        d.setServiceType(serviceTypeRepository.findByServiceTypeId(1L));
        d.setMember(memberRepository.findByMeid(1L));


        try {
            entityManager.persist(d);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println( "=========********** CoffeeDeliveryTestManuNull ********=============");
            System.out.println( e );
            System.out.println( "===================*********************============================");

        }
    }



}
