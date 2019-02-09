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
public class ControllrtAll {
    @Autowired
    private AddpointRepository addpointRepository;
    @Autowired  private MemberRepository memberRepository;
    @Autowired  private PointRepository pointRepository;
    @Autowired  private StaffRepository staffRepository;

    //=============   Sprint 2    ==================
    @Autowired private RewardRepository RewardRepository;
    @Autowired private TyperewardRepository TyperewardRepository;

    //======================================================================================================================
    @GetMapping(path = "/addpoint")
    private Collection<Addpoint> getAddpoint(){
        return this.addpointRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/point")
    private Collection<Point>getPoint() {
        return this.pointRepository.findAll().stream().collect(Collectors.toList());
    }
    //======================================================================================================================
    @PostMapping(path = "/point/{other}/{date}/{addPoint}/{nameM}/{nameStaff}")
    public Point point(@PathVariable String other, @PathVariable Date date, @PathVariable Long addPoint, @PathVariable Long nameM , @PathVariable Long nameStaff){

        Point point = new Point();
        point.setOther(other);
        point.setDate(date);

        Addpoint addpoint1 = addpointRepository.findById(addPoint).get();
        point.setAddpoint(addpoint1);

        Member memberxy1 = memberRepository.findById(nameM).get();
        point.setMember(memberxy1);

        Staff staffxy1 = staffRepository.findById(nameStaff).get();
        point.setStaff(staffxy1);

        pointRepository.save(point);
        return point;
    }

    //===================================                 Sprint2                   ==================================================

    @PostMapping(path = "/reward/{category}/{nameStaff}/{nameM}/{typeRe}/{amount}")
    public Reward reward(@PathVariable String category,@PathVariable Long nameStaff,@PathVariable Long nameM,@PathVariable Long typeRe,@PathVariable int amount){

        Reward reward = new Reward();
        reward.setCategory(category);
        reward.setAmount(amount);

        Staff staff1 = staffRepository.findById(nameStaff).get();
        reward.setStaff(staff1);

        Member member1 = memberRepository.findById(nameM).get();
        reward.setMember(member1);

        Typereward typereward1 = TyperewardRepository.findById(typeRe).get();
        reward.setTypereward(typereward1);

        RewardRepository.save(reward);
        return reward;
    }
    //=============================================== GetMap ===============================
    @GetMapping(path = "/reward")
    private Collection<Reward> getReward(){
        return this.RewardRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/typereward")
    private Collection<Typereward> getTypereward(){
        return this.TyperewardRepository.findAll().stream().collect(Collectors.toList());
    }

}
