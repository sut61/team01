package com.example.demo.controller;


import com.example.demo.entity.CoffeeDelivery;
import com.example.demo.entity.Manu;
import com.example.demo.entity.Member;
import com.example.demo.entity.ServiceType;
import com.example.demo.repository.CoffeeDeliveryRepository;
import com.example.demo.repository.ManuRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CoffeeDeliveryController {

    @Autowired
    private   CoffeeDeliveryRepository coffeeDeliveryRepository;

    @Autowired
    private ManuRepository manuRepository;
    @Autowired
    public ServiceTypeRepository serviceTypeRepository;
    @Autowired
    private MemberRepository memberRepository;



    public CoffeeDeliveryController(CoffeeDeliveryRepository coffeeDeliveryRepository) {
        this.coffeeDeliveryRepository = coffeeDeliveryRepository;
    }

    @GetMapping("/CoffeeDelivery")
    public Collection<CoffeeDelivery> CoffeeDelivery(){
        return coffeeDeliveryRepository.findAll().stream().collect(Collectors.toList());

    }

    @PostMapping("/CoffeeDelivery/{serviceType}/{member}/{manu}/{menuName}/{priece}/{lat}/{lng}")
    public CoffeeDelivery newPostCoffee(@PathVariable Long serviceType, @PathVariable Long member,
                                        @PathVariable int manu,@PathVariable int priece, @PathVariable Double lat,
                                        @PathVariable Double lng,@PathVariable String menuName){

        CoffeeDelivery newPostCoffee = new CoffeeDelivery();
        ServiceType serviceType1 = new ServiceType();
        serviceType1 = serviceTypeRepository.findByServiceTypeId(serviceType);

        Member member1 = new Member();
        member1 = memberRepository.findByMeid(member);

        Manu manu1 = new Manu();
        manu1 = manuRepository.findByManuid(manu);

        newPostCoffee.setLatitude(lat);
        newPostCoffee.setLongitude(lng);
        newPostCoffee.setPrice(priece);
        newPostCoffee.setName(menuName);
        newPostCoffee.setServiceType(serviceType1);
        newPostCoffee.setManu(manu1);

        newPostCoffee.setMember(member1);

        return coffeeDeliveryRepository.save(newPostCoffee);

    }

    @DeleteMapping("/CoffeeDelivery/{coffeeDeliveryId}")
    public void deleteCoffeeDelivery(@PathVariable Long coffeeDeliveryId)
    {

        coffeeDeliveryRepository.deleteById(coffeeDeliveryId);


    }


}
