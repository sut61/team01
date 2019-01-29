import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ManuService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) {
  }

  getCoffeeType(): Observable<any> {
    return this.http.get(this.API + '/coffeetype');
  }

  getBakerType(): Observable<any> {
    return this.http.get(this.API + '/bakerytype');
  }

  getManuType(): Observable<any> {
    return this.http.get(this.API + '/manutype');
  }

  getManu(): Observable<any> {
    return this.http.get(this.API + '/manu');

  }
}
