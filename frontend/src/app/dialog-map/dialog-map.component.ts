import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../Service/showMenu/service.service';

@Component({
  selector: 'app-dialog-map',
  templateUrl: './dialog-map.component.html',
  styleUrls: ['./dialog-map.component.css']
})

export class DialogMapComponent implements OnInit {

  constructor(public  serviceService: ServiceService) { }
  zoom = 15;
  latitude = 14.883778;
  longitude = 102.024555;
  locationChosen = false;


  onChoseLocation(enven) {
    this.latitude = enven.coords.lat;
    this.longitude = enven.coords.lng;
    this.locationChosen = true;
    console.log(enven);
  }

  clickEnter() {
     this.serviceService.markerLog = this.longitude;
     this.serviceService.markerLat = this.latitude;
     this.serviceService.push = true;
  }


  ngOnInit() {
  }

}


