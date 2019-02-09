package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CancelController {
    @Autowired private TypeDeleteRepository typeDeleteRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private CancelRepository cancelRepository;


    @GetMapping(path = "/cancel")
    private Collection<Cancel> getCancel(){
        return this.cancelRepository.findAll().stream().collect(Collectors.toList());
    }

    // @PostMapping("/Cancel/{staffid}/{meid}")
    // private Cancel newcancels(@RequestBody String dataDis,@PathVariable Long staffid, @PathVariable Long meid) throws JsonParseException, IOException {

    //     final String decoded = URLDecoder.decode(dataDis, "UTF-8");
    //     dataDis = decoded;
    //     ObjectMapper mapper = new ObjectMapper();
    //     JsonNode actualObj = mapper.readTree(dataDis);
    //     JsonNode jsonNote = actualObj.get("inputNote");


    //     Cancel cancel = new Cancel();
    //     cancel.setNote(jsonNote.textValue());
    //     cancel.setStaff(staffRepository.getOne(staffid));
    //     cancel.setMember(memberRepository.getOne(meid));

    //     return cancelRepository.save(cancel);
    // }

//======================================================================


     @PostMapping(path = "/cancel/{staffid}/{typeDeleteid}")
    public Cancel newCancel(@PathVariable Long staffid, @PathVariable Long typeDeleteid){

        Cancel newCancel = new Cancel();

        Staff staffxy1 = staffRepository.findById(staffid).get();
        newCancel.setStaff(staffxy1);

        TypeDelete typeDelete1 = typeDeleteRepository.findById(typeDeleteid).get();
        newCancel.setTypeDelete(typeDelete1);

    
        // newCancel.setNote(note);

         cancelRepository.save(newCancel);
         return newCancel;

    }

}
