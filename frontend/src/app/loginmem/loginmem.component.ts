import { Component, OnInit } from '@angular/core';
import {RecordService} from '../Service/record.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {element} from "protractor";
import {ServiceService} from "../service/service.service";

@Component({
  selector: 'app-loginmem',
  templateUrl: './loginmem.component.html',
  styleUrls: ['./loginmem.component.css']
})
export class LoginmemComponent implements OnInit {
 public member: any = {
   meid:'',
    user: '',
    password: ''
  }

  check: any = ''
  constructor(private recordService: RecordService,
              private httpClient: HttpClient,
              private router: Router,
              public  serviceService: ServiceService) { }

  ngOnInit() {
  }

  login() {
    if (this.member.user === '' || this.member.password === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {

      this.httpClient.get('http://localhost:8080/member/' + this.member.user + '/' + this.member.password, this.member)
        .subscribe(
          data =>   {
            this.check = data;
            console.log('PUT Request is successful', data);
            if (this.check === true) {
              // alert('login sucessful');
              this.router.navigate(['homemem', {
              }]);

            } else {
              alert('username หรือ password ของท่านไม่ถูกต้อง');
            }
          },
          error =>  {
            console.log('Error', error);
          }
        );
    }




  }
}
