import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class StockService {
  public  API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getStock(): Observable<any> {
    return this.http.get(this.API + '/stock');
  }
  getProduct(): Observable<any> {
    return this.http.get(this.API + '/product');
  }

  getAmount(): Observable<any> {
    return this.http.get(this.API + '/amount');
  }

  getUnit(): Observable<any> {
    return this.http.get(this.API + '/unit');
  }
}
