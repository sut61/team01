import { Component, OnInit } from '@angular/core';
import {SearchAllService} from "../service/server-all.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {RecordService} from "../service/record.service";

@Component({
  selector: 'app-reward',
  templateUrl: './reward.component.html',
  styleUrls: ['./reward.component.css']
})
export class RewardComponent implements OnInit {

  constructor(private controller: SearchAllService, private httpClient: HttpClient, private router: Router, private controller1: RecordService) {
  }


  nameStaffs: Array<any>;
  nameStaffSelect: '';


  typeRewards: Array<any>;
  typeRewardsSelect: '';

  // category4: String="shirt";


  users: Array<any>;
  userSelect:'';

  data:any = {


  }

  ngOnInit() {
    this.controller.getStaffxy().subscribe(on => {
      this.nameStaffs = on;
      console.log(this.nameStaffs);
    });

    this.controller1.getMember().subscribe(on => {
      this.users = on;
      console.log(this.users);
    });

    this.controller.getRewardType().subscribe(on => {
      this.typeRewards = on;
      console.log(this.typeRewards);
    });

  }

// cat1:String = "shirt";

  category4: String="shirt";
  category3: String="watch";
  category2: String="shoes";
  category1: String="glass";

  amount:number= 1;

  insert4(){

    if(this.nameStaffSelect == null ){alert('กรุณาเลือกพนักงานที่ทำการบันทึกข้อมูล')}
    else  if(this.userSelect == null){alert('กรุณาเลือกชื่อลูกค้า')}
    else  if(this.typeRewardsSelect == null){alert('กรุณาเลือกประเภทขแงรางวัล')}
    else {
      // @PostMapping(path = "/reward/{category}/{nameStaff}/{nameM}/{typeRe}")
      this.httpClient.post('http://localhost:8080/reward/' + this.category4 + '/' + this.nameStaffSelect + '/' + this.userSelect + '/' + this.typeRewardsSelect+'/'+this.amount, {})
        .subscribe()
      alert("SUCCESS");
      this.router.navigate(['/reward']);
    }
  }

  insert3(){
    if(this.nameStaffSelect == null ){alert('กรุณาเลือกพนักงานที่ทำการบันทึกข้อมูล')}
    else  if(this.userSelect == null){alert('กรุณาเลือกชื่อลูกค้า')}
    else  if(this.typeRewardsSelect == null){alert('กรุณาเลือกประเภทขแงรางวัล')}
    else {

      // @PostMapping(path = "/reward/{category}/{nameStaff}/{nameM}/{typeRe}")
      this.httpClient.post('http://localhost:8080/reward/' + this.category3 + '/' + this.nameStaffSelect + '/' + this.userSelect + '/' + this.typeRewardsSelect+'/'+this.amount, {})
        .subscribe()
      alert("SUCCESS");
      this.router.navigate(['/reward']);
    }
  }

  insert2(){
    if(this.nameStaffSelect == null ){alert('กรุณาเลือกพนักงานที่ทำการบันทึกข้อมูล')}
    else  if(this.userSelect == null){alert('กรุณาเลือกชื่อลูกค้า')}
    else  if(this.typeRewardsSelect == null){alert('กรุณาเลือกประเภทขแงรางวัล')}
    else {

      // @PostMapping(path = "/reward/{category}/{nameStaff}/{nameM}/{typeRe}")
      this.httpClient.post('http://localhost:8080/reward/' + this.category2 + '/' + this.nameStaffSelect + '/' + this.userSelect + '/' + this.typeRewardsSelect+'/'+this.amount, {})
        .subscribe()
      alert("SUCCESS");
      this.router.navigate(['/reward']);
    }

  }

  insert1(){
    // if(this.nameStaffSelect == null  || this.userSelect == null  || this.typeRewardsSelect == null  ){
    //   alert('กรุณากรอกข้อมูลให้ครบถ้วน')}else {
    if(this.nameStaffSelect == null ){alert('กรุณาเลือกพนักงานที่ทำการบันทึกข้อมูล')}
    else  if(this.userSelect == null){alert('กรุณาเลือกชื่อลูกค้า')}
    else  if(this.typeRewardsSelect == null){alert('กรุณาเลือกประเภทขแงรางวัล')}
    else {
      // @PostMapping(path = "/reward/{category}/{nameStaff}/{nameM}/{typeRe}")
      this.httpClient.post('http://localhost:8080/reward/' + this.category1 + '/' + this.nameStaffSelect + '/' + this.userSelect + '/' + this.typeRewardsSelect+'/'+this.amount, {})
        .subscribe()
      alert("SUCCESS");
      this.router.navigate(['/reward']);
    }

  }



}
