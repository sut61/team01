package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StaffRepository staffRepository;

    public DeliveryController(DeliveryRepository deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }


    @GetMapping("/Delivery")
    public Collection<Delivery> Delivery(){
        return deliveryRepository.findAll().stream().collect(Collectors.toList());

    }

    @PostMapping("/Delivery/{name}/{price}/{latitude}/{longitude}/{status}/{statusName}/{staff}/{staffName}/{note}")
    public Delivery delivery(@PathVariable String name,@PathVariable int price,@PathVariable double latitude,
                             @PathVariable double longitude,@PathVariable Long status,@PathVariable Long staff,
                             @PathVariable String note,@PathVariable String statusName,@PathVariable String staffName)
    {
        Delivery delivery = new Delivery();
        Status status1 = new Status();
        Staff staff1 = new Staff();

        status1 = statusRepository.findBystatusId(status);
//        staff1 = staffRepository.findById(staff);

        delivery.setName(name);
        delivery.setPrice(price);
        delivery.setLatitude(latitude);
        delivery.setLongitude(longitude);
        delivery.setStatus(status1);
        delivery.setStatusName(statusName);
        delivery.setStaff(staff);
        delivery.setStaffName(staffName);
        delivery.setNote(note);

        return  deliveryRepository.save(delivery);

    }






}
