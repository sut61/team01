import { Component, OnInit } from '@angular/core';
import {RecordService} from '../Service/record.service';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-record',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  users: Array<any>;
  payment: Array<any>;
  membernames: Array<any>;
  staffNames: Array<any>;
  customername: Array<any>;

  userSelect: number = 0;
  membernameSelect: number = 0;
  staffNameSelect:number =0;
  customerNameSelect:number =0;

  addis: any = {
    inputNote: ''
  }

  constructor(private recordService: RecordService,
              private httpClient: HttpClient) { }

  ngOnInit() {
    this.recordService.getMember().subscribe(data => {
      this.users = data;
      console.log(this.users);
    });
    this.recordService.getPayment().subscribe(data => {
      this.payment = data;
      console.log(this.payment);
    });
    this.recordService.getCoffeeordes().subscribe(data => {
      this.membernames = data;
      console.log(this.membernames);
    });
    this.recordService.getStaff().subscribe(data => {
      this.staffNames = data;
      console.log(this.staffNames);
    });
    this.recordService.getCustomer().subscribe(data => {
      this.customername = data;
      console.log(this.customername);
    });
  }

  save() {
    if (this.addis.inputNote === '' || this.userSelect === 0 || this.customerNameSelect === 0 || this.staffNameSelect === 0 ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('//localhost:8080/payment' + '/' + this.userSelect + '/' + this.customerNameSelect + '/' +
        this.staffNameSelect + '/' , this.addis)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);

          }
        );
    }

  }
}

