import { Component, OnInit } from '@angular/core';
import {SearchAllService} from "../service/server-all.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-point-view',
  templateUrl: './point-view.component.html',
  styleUrls: ['./point-view.component.css']
})
export class PointViewComponent implements OnInit {

  constructor(private controller:SearchAllService,private httpClient:HttpClient,private router:Router) { }

  points:Array<any>;

  ngOnInit() {

    this.controller.getPoint().subscribe(data =>{
      this.points = data;
      console.log(this.points);
    });



  }

}
