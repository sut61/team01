import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css'],
})
export class AboutComponent implements OnInit {

  orders: Array<any>;

  displayColumns: string[] = [''];

  title = 'Select Menu';

  constructor() { }


  ngOnInit() {

  }




}
