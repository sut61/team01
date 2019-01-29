
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { AllserviceService } from '../service/allservice.service';

@Component({
  selector: 'app-viewcoffeeorder',
  templateUrl: './viewcoffeeorder.component.html',
  styleUrls: ['./viewcoffeeorder.component.css']
})
export class ViewcoffeeorderComponent implements OnInit {

  orders: Array<any>;

  constructor(private allservice: AllserviceService , private httpClient: HttpClient, private router: Router) { }


  ngOnInit() {
    this.allservice.getCoffeeorder().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
  }
}
