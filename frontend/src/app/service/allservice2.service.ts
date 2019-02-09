import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class Allservice2Service {
  public API = '//localhost:8080';


  constructor(private httpClient:HttpClient) { }

  getTaste():Observable<any>{
    return this.httpClient.get(this.API+'/taste');
  }

  getService():Observable<any>{
    return this.httpClient.get(this.API+'/service');
  }

  getVibe():Observable<any>{
    return this.httpClient.get(this.API+'/vibe');
  }

  getPrice():Observable<any>{
    return this.httpClient.get(this.API+'/price');
  }

  getFeedback():Observable<any>{
    return this.httpClient.get(this.API+'/feedback');
  }


}
