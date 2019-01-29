import { Component, OnInit } from '@angular/core';
import {AllserviceService} from "../service/allservice.service";
import {Route, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {RecordService} from '../Service/record.service';

@Component({
  selector: 'app-coffeeorder',
  templateUrl: './coffeeorder.component.html',
  styleUrls: ['./coffeeorder.component.css']
})
export class CoffeeorderComponent implements OnInit {

  constructor(private controller:AllserviceService,private router:Router,private httpClient:HttpClient,private controller1:RecordService) { }


  itemNames:Array<any>;
  itemNameSelect:'';

  totalPrice:string;
  quantity:string;

  customerNames:Array<any>;
  customerNameSelect:'';

  orderTypes:Array<any>;
  orderTypeSelect:'';

  staffNames:Array<any>;
  staffNameSelect:'';

  users: Array<any>;
  userSelect: number = 0;

  data:any = {


}

  ngOnInit() {
    this.controller.getCoffeemenu().subscribe(data =>{
      this.itemNames = data;
      console.log(this.itemNames);
    });

    this.controller.getOrdertype().subscribe(data =>{
      this.orderTypes = data;
      console.log(this.orderTypes);
    });

    this.controller.getStaff().subscribe(data =>{
      this.staffNames = data;
      console.log(this.staffNames);
    });

    this.controller1.getMember().subscribe(on =>{
      this.users = on;
      console.log(this.users);
    });





  }

  insert(){
    this.httpClient.post('http://localhost:8080/coffeeorder/'+this.staffNameSelect+'/'+this.userSelect+'/'+this.itemNameSelect+'/'+this.quantity+'/'+this.totalPrice+'/'+this.orderTypeSelect,{})
      .subscribe()
    alert("SUCCESS");
    this.router.navigate(['/viewcoffeeorders']);


  }

}
