import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../Service/service.service';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-dialog-shopping-car',
  templateUrl: './dialog-shopping-car.component.html',
  styleUrls: ['./dialog-shopping-car.component.css']
})
export class DialogShoppingCarComponent implements OnInit {

  public API = '//localhost:8080';

  public  delivery = {
    coffeeDeliveryId : Number,
    price : Number,
    name : String,
  };
  dataColumns: string[] = ['item', 'price', 'number', 'CreditPay'];

  DeleteDelivery(deliveryId) {
    if (this.serviceService.push === false) {
      this.http.delete(this.API + '/CoffeeDelivery' +  '/' + deliveryId).subscribe(
        data => {
          console.log(' Delet is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    } else {
      this.serviceService.counter = this.serviceService.counter - 1 ;
      this.http.delete(this.API + '/CoffeeDelivery' +  '/' + deliveryId).subscribe(
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



  getDelivery(): Observable<any> {

    return this.http.get(this.API + '/CoffeeDelivery');
  }

  constructor( public  serviceService: ServiceService, public  http: HttpClient) { }

  ngOnInit() {
    this.getDelivery().subscribe(data => {
      this.delivery = data;
      console.log(this.delivery);
    });

  }



}
