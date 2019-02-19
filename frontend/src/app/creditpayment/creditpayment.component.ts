import { Component, OnInit } from '@angular/core';
import {RecordService} from "../service/record.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-creditpayment',
  templateUrl: './creditpayment.component.html',
  styleUrls: ['./creditpayment.component.css']
})
export class CreditpaymentComponent implements OnInit {

  constructor(private recordService: RecordService,
              private httpClient: HttpClient, private router: Router) {
  }

  creditname: string;
  creditnumber: number;
  csc: number;
  expireddate: null;
  money: number;

  //ชื่อสตาฟ
  staffNames: Array<any>;
  staffNameSelect: '';

  //ชื่อสมาชิก
  nameMs: Array<any>;
  nameMSelect: '';

  //ID order
  orderids: Array<any>;
  orderidSelect: '';

  //ประเภทบัตรเครดิต
  typenames: Array<any>;
  typenameSelect: '';

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
    this.recordService.getCredittype().subscribe(on => {
      this.typenames = on;
      console.log(this.typenames);
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
    else if (this.creditname == null) {
      alert('กรุณาเกรอกชื่อเจ้าของบัตร')
    }
    else if (this.creditname == null) {
      alert('กรุณาเกรอกชื่อเจ้าของบัตร')
    }
    else if (this.creditname == null) {
      alert('กรุณาเกรอกชื่อเจ้าของบัตร')
    }
    else if (this.creditnumber == null) {
      alert('กรุณาเกรอกหมายเลขบัตร')
    }
    else if (this.csc == null) {
      alert('กรุณาเกรอกรหัส 3ตัว ของบัตร')
    }
    else if (this.expireddate == null) {
      alert('กรุณาเเลือกวันที่')
    }
    else if (this.money == null) {
      alert('กรุณากรอกจำนวนเงิน')
    }
    else if (this.typenameSelect == null) {
      alert('กรุณาเเลือกประเภทของบัตร')
    }
    else {
      this.httpClient.post('http://localhost:8080/creditcardpayment/' + this.nameMSelect + '/' + this.orderidSelect + '/' + this.staffNameSelect + '/' + this.creditname + '/' + this.creditnumber + '/' + this.csc + '/' + this.expireddate + '/' + this.typenameSelect + '/' + this.money, {})
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
