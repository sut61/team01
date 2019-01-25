import { Component, OnInit } from '@angular/core';
import {RecordService} from '../Service/record.service';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './showpay.component.html',
  styleUrls: ['./showpay.component.css']
})
export class ShowpayComponent implements OnInit {

  id: number;
  staffname: string;
  ordertypeid: string;
  memberid: number;
  membername: string;
  itemid: number;
  itemname: string;
  itemprice: number;
  Quantity: number;
  totalPrice: number;
  cpoint: number;


  dataColumns: string[] = ['order no.', 'totalPrice', 'cashpay'];


  CoffeeOrder: Array<any>;

  constructor(private recordService: RecordService, private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.recordService.getCoffeeordes().subscribe(data => {
      this.CoffeeOrder = data;
      console.log(this.CoffeeOrder);
    });
  }


  cashpay(element): void {
    this.router.navigate(['payment/' + element.orderid]);
  }


}
