import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) {
  }

  getNameType(): Observable<any> {
    return this.http.get(this.API + '/nametype');
  }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/gender');
  }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/province');
  }
}
