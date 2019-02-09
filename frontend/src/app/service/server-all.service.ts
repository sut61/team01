import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SearchAllService {
  public API = '//localhost:8080';

  constructor(private httpClient: HttpClient) {
  }


  //addPoint
  getAddpoint(): Observable<any>{
    return this.httpClient.get(this.API+'/addpoint');
  }

  //memberxy
  getMemberxy():Observable<any>{
    return this.httpClient.get(this.API+'/member');
  }

  //point
  getPoint () :Observable<any>{
    return this.httpClient.get(this.API+'/point');
  }

  //staffxy
  getStaffxy () : Observable<any>{
    return this.httpClient.get(this.API+'/staff');
  }


  //======================================= Sprint2  ===============================================

  getReward () : Observable<any>{
    return this.httpClient.get(this.API+'/reward');
  }

  getRewardType () : Observable<any>{
    return this.httpClient.get(this.API+'/typereward');
  }
  getTypeDelete () : Observable<any>{
    return this.httpClient.get(this.API+'/typedelete');
  }

}

