import { Component, OnInit } from '@angular/core';
import {element} from "protractor";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-homemem',
  templateUrl: './homemem.component.html',
  styleUrls: ['./homemem.component.css']
})
export class HomememComponent implements OnInit {
  private router: any;

  constructor() {router: Router }

  ngOnInit() {
  }

  like(element): void {
    this.router.navigate(['CoffeeDelivery/' + element.meid]);
  }



}
