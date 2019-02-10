import { Component, OnInit } from '@angular/core';
import {ServiceService} from '../Service/service.service';

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

  memberNeme: Array<any>;
  member: any = {
    memberNameSelect: ''
  };


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
     this.serviceService.numberMember = this.member.memberNameSelect;
  }





  ngOnInit() {

    this.serviceService.getMember().subscribe(data => {
      this.memberNeme = data;
      console.log(this.memberNeme);
    });

    if (this.member.memberNameSelect === '') {
      this.serviceService.push2 = true;
    }


  }

}


