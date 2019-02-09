import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ServiceService} from '../Service/service.service';
import {RecordService} from '../Service/record.service';
import {MemberService} from '../service/member.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  [x: string]: any;  
    public API = '//localhost:8080';
  
    public  member = {
    meid : Number,
    nameM : Number,
    username : String,
    password : String,
  };
  dataColumns: string[] = ['id', 'nameM', 'user','pass', 'CreditPay'];

  DeleteMember(meid) {
    if (this.serviceService.push === false) {
      this.http.delete(this.API + '/member' +  '/' + meid).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    } else {
      this.serviceService.counter = this.serviceService.counter - 1 ;
      this.http.delete(this.API + '/member' +  '/' + meid).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );


    }

  }

  end() {
    if (this.serviceService.push === false) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน ');
    } else {
      alert('ดำเนินการเสร็จสิ้น');
    }
  }



  getmember(): Observable<any> {

    return this.http.get(this.API + '/member');
  }


  constructor(public  serviceService: ServiceService,private memberService: MemberService,
    private recordService: RecordService, public  http: HttpClient) { }

  ngOnInit() {
    this.getmember().subscribe(data => {
      this.member = data;
      console.log(this.member);
    });
    this.serviceService.getMember().subscribe(data => {
      this.serviceService.member = data;
      console.log(this.serviceService.member);
    });

    this.recordService.getStaff().subscribe(data => {
      this.staffNames = data;
      console.log(this.staffNames);
    });
    this.recordService.getMember().subscribe(data => {
      this.users = data;
      console.log(this.users);
    });

  }

}
