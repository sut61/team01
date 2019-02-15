import { Component, OnInit } from '@angular/core';
import {SearchAllService} from "../service/server-all.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {RecordService} from '../Service/record.service';
@Component({
  selector: 'app-point',
  templateUrl: './point.component.html',
  styleUrls: ['./point.component.css']
})
export class PointComponent implements OnInit {

  constructor(private controller:SearchAllService,private httpClient:HttpClient,private router:Router,private controller1:RecordService) { }

//Point

  other:String;
  date:null;

//Addpoint
  addPoints : Array<any>;
  addPointSelect: '';
  // constructor() { }

  //nameStaff
  nameStaffs : Array<any>;
  nameStaffSelect:'';


  
  //nameCustomer
  nameCustomers : Array<any>;
  nameMSelect:'';

  users: Array<any>;
  userSelect: '';

  data:any = {


}

  ngOnInit() {
    this.controller.getAddpoint().subscribe(on =>{
      this.addPoints = on;
      console.log(this.addPoints);
    });

    this.controller.getStaffxy().subscribe(on =>{
      this.nameStaffs = on;
      console.log(this.nameStaffs);
    });

    this.controller1.getMember().subscribe(on =>{
      this.users = on;
      console.log(this.users);
    });
  }




  insert(){
    if(this.date == null){
      alert("กรุณากรอกวันที่");
    }else if(this.other == null) {
      alert("กรุณากรอกข้อมูลอื่นๆ");
    }else if(this.addPointSelect == null){
      alert("กรุณาเลือกจำนวนพอยท์");
    }else if(this.userSelect == null){
      alert("กรุณาเลือกลูกค้า");
    }else if (this.nameStaffSelect == null) {
      alert("กรุณาเลือกพนักงานที่จำการบันทึกข้อมูล");
    }else {
      this.httpClient.post('http://localhost:8080/point/' + this.other + '/' + this.date + '/' + this.addPointSelect + '/' + this.userSelect + '/' + this.nameStaffSelect, {})
        .subscribe()
      alert("สำเร็จ");
      this.router.navigate(['point-view']);
    }
  }

}
