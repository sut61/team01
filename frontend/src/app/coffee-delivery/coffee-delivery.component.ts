import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {DialogMapComponent} from '../dialog-map/dialog-map.component';
import {DialogShoppingCarComponent} from '../dialog-shopping-car/dialog-shopping-car.component';
import {HttpClient} from '@angular/common/http';
import {ServiceService} from '../Service/showMenu/service.service';


@Component({
  selector: 'app-coffee-delivery',
  templateUrl: './coffee-delivery.component.html',
  styleUrls: ['./coffee-delivery.component.css']
})
export class CoffeeDeliveryComponent implements OnInit {


  constructor( public  httpClient: HttpClient , public dialog: MatDialog , public  serviceService: ServiceService) {}

  public  numberMenu = 0;

      openDialogMap() {
        const dialogRef = this.dialog.open(DialogMapComponent);
        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog result: ${result}`);
        });
      }
      openDialogMapShoppingCar() {
        const dialogRef = this.dialog.open(DialogShoppingCarComponent);
        dialogRef.afterClosed().subscribe(result => {
          console.log(`Dialog result: ${result}`);
        });
      }


  ngOnInit() {

    this.serviceService.getMember().subscribe(data => {
      this.serviceService.member = data;
      console.log(this.serviceService.member);
    });

    this.serviceService.getMenu().subscribe(data => {
      this.serviceService.menu = data;
      console.log(this.serviceService.menu);
    });

    this.serviceService.getServiceType().subscribe(data => {
      this.serviceService.serviceType = data;
      console.log(this.serviceService.serviceType);
    });



  }

  save(numberMenu) {

    if (this.serviceService.push === false) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน   You don\'t choose location.');
    } else {

        this.serviceService.counter = this.serviceService.counter + 1 ;


        this.httpClient.post('http://localhost:8080/CoffeeDelivery' + '/' + 1 + '/' + this.serviceService.member[0].memberId + '/' + this.serviceService.menu[numberMenu].id +
      '/' + this.serviceService.menu[numberMenu].name + '/' + this.serviceService.menu[numberMenu].price + '/' + this.serviceService.markerLat + '/' + this.serviceService.markerLog, this.serviceService.member)
          .subscribe(
            data => {
              console.log('POST Request is successful', data);
            },
            error => {
              console.log('Error', error);
            }
          );
    }
  }





  }

