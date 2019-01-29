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


  public member = {
    meid : '',
    nameM : String,
    tel : '',
    email : '',
    address : '',
    province : '',
    sex : '',

  };

  menu = {
    manuid : Number,
    name : String,
    price : '',
  };
  public i = 0;





  public serviceType: any;

  getMember(): Observable<any> {
    return this.http.get(this.API + '/member');
  }
  getMenu(): Observable<any> {
    return this.http.get(this.API + '/Manu');
  }

  getServiceType(): Observable<any> {
    return this.http.get(this.API + '/ServiceType');
  }





  constructor(public  http: HttpClient ) { }
}
