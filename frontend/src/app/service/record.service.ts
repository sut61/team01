import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RecordService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMember() : Observable<any> {
    return this.http.get(this.API + '/member');
  }
  getPayment() : Observable<any> {
    return this.http.get(this.API + '/payment');
  }
  getCoffeeordes(): Observable<any> {
    return this.http.get(this.API + '/coffeeorders');
  }
  getStaff(): Observable<any> {
    return this.http.get(this.API + '/staff');
  }
}
