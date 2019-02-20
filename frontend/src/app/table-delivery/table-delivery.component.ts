import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ServiceService} from '../service/service.service';
import {HttpClient} from '@angular/common/http';
import {DialogSendCoffeeComponent} from '../dialog-send-coffee/dialog-send-coffee.component';
import {MatDialog, MatDialogConfig} from '@angular/material';

@Component({
  selector: 'app-table-delivery',
  templateUrl: './table-delivery.component.html',
  styleUrls: ['./table-delivery.component.css']
})
export class TableDeliveryComponent implements OnInit {

  public API = '//localhost:8080';

  constructor( public  serviceService: ServiceService, public  http: HttpClient, public dialog: MatDialog ) { }

  dataColumns: string[] = ['item', 'price', 'lat', 'log', 'member', 'CreditPay'];

  dataColumns2: string[] = ['id', 'name', 'price', 'lat', 'log', 'staff', 'status'];

  public  delivery = {
    coffeeDeliveryId : Number,
    price : Number,
    name : String,

  };

  public deliveryTable = {
    deliveryId : '',
    latitude : '',
    longitude : '',
    name : '',
    price: '',
    statusName: '',
    staffName: '',


  };



  getDelivery(): Observable<any> {

    return this.http.get(this.API + '/CoffeeDelivery');
  }

  openDialogSendCoffee(idd) {
    const dialogConfig = new MatDialogConfig();
    this.serviceService.coffeeId = idd;
    console.log(`Dialog result: ${idd}`);

    this.dialog.open(DialogSendCoffeeComponent, dialogConfig);


  }

  getdeliveryStatus(): Observable<any> {
    return this.http.get(this.API + '/Delivery');
  }

  lond() {
    window.location.reload();
  }

  ngOnInit() {

    this.getDelivery().subscribe(data => {
      this.delivery = data;
      console.log(this.delivery);
    });

    this.getdeliveryStatus().subscribe( data => {
      this.deliveryTable = data;
    });

  }

}
