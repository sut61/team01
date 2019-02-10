import { Component, OnInit } from '@angular/core';
import {SearchAllService} from "../service/server-all.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {RecordService} from '../Service/record.service';
import {MemberService} from '../Service/member.service';

@Component({
  selector: 'app-cancel-member',
  templateUrl: './cancel-member.component.html',
  styleUrls: ['./cancel-member.component.css']
})
export class CancelMemberComponent implements OnInit {

  constructor(private controller:SearchAllService,private httpClient:HttpClient,
              private router:Router,private controller1:RecordService,private memberService:MemberService) { }


//nameStaff
nameStaffs : Array<any>;
nameStaffSelect:number =0;

//member

type: Array<any>;
typeSelect:number =0;

data:any = {
}

ngOnInit() {
    this.controller.getStaffxy().subscribe(on =>{
    this.nameStaffs = on;
    console.log(this.nameStaffs);
  });

  this.controller.getTypeDelete().subscribe(on =>{
    this.type = on;
    console.log(this.type);
  });
}

note:String;
date:null;
reason:String;

insert(){
  if (this.typeSelect === 0 || this.nameStaffSelect === 0 ||this.date === 0 ||this.note===''||this.reason==='') {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
  } else {
    // @PostMapping(path = "/cancel/{staffid}/{typeDeleteid}/{date}/{note}/{reason}")

  this.httpClient.post('http://localhost:8080/cancel/'+this.nameStaffSelect+'/' +this.typeSelect+'/'+this.date+'/'+this.note+'/'+this.reason ,   {})
    .subscribe()
  alert("สำเร็จ");
  this.router.navigate(['delete']);
  } 
  }

} 
