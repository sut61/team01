import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { ManuService} from '../service/manu.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showmanu',
  templateUrl: './showmanu.component.html',
  styleUrls: ['./showmanu.component.css']
})
export class ShowmanuComponent implements OnInit {
  manuid: number;
  name: string;
  price: number;
  manut: string;
  coffee: string;
  bakery: string;

  dataColumns: string[] = ['No.', 'Manu Name', 'Price'];

  manu: Array<any>;

  constructor(private manuService: ManuService ,
              private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
    this.manuService.getManu().subscribe(data => {
      this.manu = data;
      console.log(this.manu);
    });
  }
}
