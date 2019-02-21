import { Component, OnInit } from '@angular/core';
import {RecordService} from '../Service/record.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';


@Component({
  selector: 'app-record',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private recordService: RecordService,
              private httpClient: HttpClient, private router: Router) {
  }

 note: string;
 cash: number;
 change: number;
 discount: number;
 date: null;

  //ชื่อสตาฟ
  staffNames: Array<any>;
  staffNameSelect: '';

  //ชื่อสมาชิก
  nameMs: Array<any>;
  nameMSelect: '';

  //ID order
  orderids: Array<any>;
  orderidSelect: '';

  data: any = {}


  ngOnInit() {
    this.recordService.getStaff().subscribe(on => {
      this.staffNames = on;
      console.log(this.staffNames);
    });
    this.recordService.getMember().subscribe(on => {
      this.nameMs = on;
      console.log(this.nameMs);
    });
    this.recordService.getCoffeeorder().subscribe(on => {
      this.orderids = on;
      console.log(this.orderids);
    });
  }

  insert() {
    if (this.orderidSelect == null) {
      alert('กรุณาเลือก ID order')
    }
    else if (this.nameMSelect == null) {
      alert('กรุณาเลือกชื่อลูกค้า')
    }
    else if (this.staffNameSelect == null) {
      alert('กรุณาเลือกพนักงาน')
    }
    else if (this.discount == null) {
      alert('กรุณากรอกจำนวนเงิน')
    }
    else if (this.cash == null) {
      alert('กรุณากรอกจำนวนเงิน')
    }
    else if (this.change == null) {
      alert('กรุณากรอกจำนวนเงิน')
    }
    else if (this.date == null) {
      alert('กรุณาเลือกวันที่')
    }
    else if (this.note == null) {
      alert('กรุณากรอกข้อความ')
    }
    else {
      this.httpClient.post('http://localhost:8080/payment/' + this.nameMSelect + '/' + this.orderidSelect + '/' + this.staffNameSelect + '/' + this.discount + '/' + this.cash + '/' + this.change + '/' + this.date + '/' + this.note, {})
        .subscribe(data => {
            console.log('PUT Request is successful', data);
            alert("สำเร็จ");
          },
          error => {
            console.log('Error', error);
            alert("บันทึกข้อมูลผิดพลาด");
          });


    }
  }
}

