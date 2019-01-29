import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AllserviceService {
  public API = '//localhost:8080';


  constructor(private httpClient:HttpClient) { }

  getCoffeemenu():Observable<any>{
    return this.httpClient.get(this.API+'/coffeemenu');
  }

  getCoffeeorder():Observable<any>{
    return this.httpClient.get(this.API+'/coffeeorder');
  }

  getCustomer():Observable<any>{
    return this.httpClient.get(this.API+'/customer');
  }

  getOrdertype():Observable<any>{
    return this.httpClient.get(this.API+'/ordetytpe');
  }

  getStaff():Observable<any>{
    return this.httpClient.get(this.API+'/staff');
  }

}
