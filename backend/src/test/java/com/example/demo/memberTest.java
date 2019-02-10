package com.example.demo;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
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
    //test null
    public void testNoteAddress() {
        Member member = new Member();
        member.setAddress(null);
        member.setNameM("Alis");
        member.setUser("user");
        member.setPassword("1234");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("note is null");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================================ Note Cannot Null ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    //min 
    public void testSizeMinUser() {
        Member member = new Member();
        member.setUser("jj");
        member.setAddress(null);
        member.setNameM("Alis");
        member.setPassword("1234");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("user too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ UserMinsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    //max 
    public void testSizeMaxUser() {
        Member member = new Member();
        member.setUser("ABCDEFGHIJK");
        member.setAddress(null);
        member.setNameM("Alis");
        member.setPassword("1234");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("User too less character");
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("================================ UserMaxsize ==================");
            System.out.println(e.getConstraintViolations());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

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

}
