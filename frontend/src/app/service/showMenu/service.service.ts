import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  public API = '//localhost:8080';
  public markerLat: any;
  public markerLog: any;

  public counter = 0;
  public push = false;
  public numberMember = 0;
  public numberOfMenu: Array <number>

  public member = {
    memberId : '',
    name : String,
    tel : '',
    email : '',
    address : '',
    province : '',
    sex : '',

  };

   menu = {
    id : Number,
    name : String,
    price : '',
  };
  public i = 0;
  // public menuSave = {
  //   id : '',
  //   name : '',
  //   price : '',
  //   piece : 1
  // };




  public serviceType: any;

  getMember(): Observable<any> {
    return this.http.get(this.API + '/Member');
  }
  getMenu(): Observable<any> {
    return this.http.get(this.API + '/manu');
  }

  getServiceType(): Observable<any> {
    return this.http.get(this.API + '/ServiceType');
  }





  constructor(public  http: HttpClient ) { }
}
