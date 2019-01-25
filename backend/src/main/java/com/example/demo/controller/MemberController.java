package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.io.IOException;
import java.net.URLDecoder;
import  java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class MemberController {
    @Autowired private MemberRepository memberRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private GenderRepository genderRepository;
    @Autowired private NametypeRepository nametypeRepository;

    @GetMapping(path = "/member")
    private Collection<Member> getMember(){
        return this.memberRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/member/{nid}/{gid}/{pid}")
    private Member newmembers(@RequestBody String dataDis,@PathVariable Long nid, @PathVariable Long gid,
                          @PathVariable Long pid) throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonName = actualObj.get("inputName");
        JsonNode jsonAddress = actualObj.get("inputAddress");
        JsonNode jsonUser = actualObj.get("inputUser");
        JsonNode jsonPass = actualObj.get("inputPass");


        Member member = new Member();
        member.setNameM(jsonName.textValue());
        member.setAddress(jsonAddress .textValue());
        member.setUser(jsonUser .textValue());
        member.setPassword(jsonPass .textValue());
        member.setG(genderRepository.getOne(gid));
        member.setP(provinceRepository.getOne(pid));
        member.setN(nametypeRepository.getOne(nid));
        return memberRepository.save(member);



    }

}
