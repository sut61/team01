package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CreditcardpaymentController {

    @Autowired
    CreditcardpaymentRepository creditcardpaymentRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CoffeeOrderRepository coffeeorderRepository;
    @Autowired
    CredittypeRepository credittypeRepository;

    @GetMapping(path = "/creditcardpayment")
    private Collection<Creditcardpayment> getCreditcardpayment(){
        return this.creditcardpaymentRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/creditcardpayment/{nameM}/{orderid}/{staffName}/{creditname}/{creditnumber}/{csc}/{expireddate}/{typename}/{discount}/{money}")
    public Creditcardpayment creditcardpayment(@PathVariable String creditname, @PathVariable Long creditnumber, @PathVariable Integer csc, @PathVariable Long staffName, @PathVariable Long nameM, @PathVariable Long orderid, @PathVariable Long typename, @PathVariable Date expireddate, @PathVariable Double money, @PathVariable Double discount){



        Creditcardpayment creditcardpayment = new Creditcardpayment();
        creditcardpayment.setCreditname(creditname);
        creditcardpayment.setCreditnumber(creditnumber);
        creditcardpayment.setCsc(csc);
        creditcardpayment.setExpireddate(expireddate);
        creditcardpayment.setDiscount(discount);
        creditcardpayment.setMoney(money);

        Staff staff1 = staffRepository.findById(staffName).get();
        creditcardpayment.setStaff(staff1);

        Member member1 = memberRepository.findById(nameM).get();
        creditcardpayment.setMember(member1);

       CoffeeOrder coffeeOrder1 = coffeeorderRepository.findById(orderid).get();
       creditcardpayment.setCoffeeorder(coffeeOrder1);

        Credittype credittype1 = credittypeRepository.findById(typename).get();
        creditcardpayment.setCredittype(credittype1);

        creditcardpaymentRepository.save(creditcardpayment);
        return creditcardpayment;

    }
}
