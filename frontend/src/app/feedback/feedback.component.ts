import { Component, OnInit } from '@angular/core';
import { Allservice2Service } from '../service/allservice2.service';
import { Router } from '@angular/router';

import { RecordService } from '../Service/record.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {


  constructor(private controller: Allservice2Service, private router: Router, private httpClient: HttpClient) { }


  taste: Array<any>;
  tasteSelect: '';

  comment: string;

  oid: string;

  service: Array<any>;
  serviceSelect: '';

  vibe: Array<any>;
  vibeSelect: '';

  price: Array<any>;
  priceSelect: '';

  data: any = {


}

  ngOnInit() {
    this.controller.getTaste().subscribe(data => {
      this.taste = data;
      console.log(this.taste);
    });

    this.controller.getService().subscribe(data => {
      this.service = data;
      console.log(this.service);
    });

    this.controller.getVibe().subscribe(data => {
      this.vibe = data;
      console.log(this.vibe);
    });

    this.controller.getPrice().subscribe(data => {
      this.price = data;
      console.log(this.price);
    });




  }

  insert(){
    if(this.tasteSelect == null || this.serviceSelect == null || this.vibeSelect == null || this.priceSelect == null || this.comment == null || this.oid == null) {
      alert('กรุณาใส่ข้อมูลให้ครบถ้วน')
      this.router.navigate(['/feedback']);} else {

    this.httpClient.post('http://localhost:8080/feedback/' + this.tasteSelect + '/' + this.serviceSelect + '/' + this.vibeSelect + '/' + this.priceSelect + '/' + this.comment+ '/' + this.oid , {}).subscribe()
    alert("ขอบคุณสำหรับ feedback ของท่าน");
    this.router.navigate(['/viewfeedback']);


  }
}

}
