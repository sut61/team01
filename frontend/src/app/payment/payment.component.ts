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
  staffNames: Array<any>;
  ids: Array<any>;

  userSelect: number = 0;
  staffNameSelect:number = 0;
  idsSelect:number = 0;

  addis: any = {
    inputNote: '',
    inputMoney: ''
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
    this.recordService.getCoffeeorder().subscribe(data => {
      this.ids = data;
      console.log(this.ids);
    });
    this.recordService.getStaff().subscribe(data => {
      this.staffNames = data;
      console.log(this.staffNames);
    });
    
  }

  save() {
    if (this.addis.inputNote === '' || this.userSelect === 0 || this.idsSelect === 0 || this.staffNameSelect === 0 ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('//localhost:8080/payment' + '/' + this.userSelect + '/' + this.idsSelect + '/' +
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

