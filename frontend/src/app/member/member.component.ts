import { Component, OnInit } from '@angular/core';
import {MemberService} from '../service/member.service';
import {Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {ServiceService} from "../service/service.service";

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
  addmember: any = {
    inputName: '',
    inputAddress: '',
    inputUser: '',
    inputPass: ''
}
  member: Array<any>;
  namedocs: Array <any>;
  genders: Array <any>;
  namepas: Array <any>;

  nametypeSelect: number = 0;
  genderSelect:number = 0;
  provinceSelect: number = 0;
  number=0;

  constructor(public memberService: MemberService,
              public httpClient: HttpClient,
              public router: Router ,
              public  serviceService: ServiceService) { }

  ngOnInit() {
    this.memberService.getNameType().subscribe(data => {
      this.namedocs = data;
      console.log(this.namedocs);
    });
    this.memberService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });
    this.memberService.getProvince().subscribe(data => {
      this.namepas = data;
      console.log(this.namepas);
    });

}
  save() {
    if (this.nametypeSelect === 0 || this.addmember.inputName === '' || this.genderSelect === 0  ||
      this.addmember.inputAddress === '' || this.provinceSelect === 0 || this.addmember.inputUser === '' ||
    this.addmember.inputPass === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {




      this.httpClient.post('http://localhost:8080/member/' + this.nametypeSelect + '/' +
        this.genderSelect + '/' + this.provinceSelect , this.addmember)
        .subscribe(

          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }

        );

      alert('บันทึกข้อมูลสำเร็จ');
    }
  }

  push(){

    this.serviceService.numberMember = this.serviceService.numberMember + this.number ;
    this.number++;
  }
}
