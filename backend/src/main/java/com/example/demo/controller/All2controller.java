package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class All2controller{
    @Autowired private VibeRepository vibeRepository;
    @Autowired private ServiceRepository serviceRepository;
    @Autowired private FeedbackRepository feedbackRepository;
    @Autowired private PriceRepository priceRepository;
    @Autowired private TasteRepository tasteRepository;



    @GetMapping(path = "/vibe")
    private Collection<Vibe> getVibe(){
        return this.vibeRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/service")
    private Collection<Service> getService(){
        return this.serviceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/feedback")
    private Collection<Feedback> getFeedback(){
        return this.feedbackRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/price")
    private Collection<Price> getPrice(){
        return this.priceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/taste")
    private Collection<Taste> getTaste(){
        return this.tasteRepository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping(path = "/feedback/{taste}/{service}/{vibe}/{price}/{comment}")
    public Feedback feedback(@PathVariable Long taste, @PathVariable Long service, @PathVariable Long vibe, @PathVariable Long price, @PathVariable String comment){


        Feedback feedback = new Feedback();
        feedback.setComment(comment);


       Taste taste1 = tasteRepository.findById(taste).get();
       feedback.setTaste(taste1);

        Service service1 = serviceRepository.findById(service).get();
        feedback.setService(service1);

        Vibe vibe1 = vibeRepository.findById(vibe).get();
        feedback.setVibe(vibe1);

        Price price1 = priceRepository.findById(price).get();
        feedback.setPrice(price1);



        feedbackRepository.save(feedback);
        return feedback;


    }

}
