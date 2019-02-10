import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {StockService} from '../service/stock.service';
import {SearchAllService} from '../service/server-all.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  date: null;
  data: any = {}

  stocks: Array <any>;

  priceperitem: any;
  totalprice: any;
  note: any;

  points: Array<any>;
  products: Array<any>;
  amounts: Array<any>;
  units: Array<any>;
  productSelect = '';
  amountSelect = '';
  unitSelect = '';



  constructor(private stockSevice: StockService,
              private httpClient: HttpClient,
              private router: Router,
              private controller: SearchAllService) { }



  ngOnInit() {
    this.stockSevice.getProduct().subscribe( data => {
      this.products = data;
      console.log(this.products);
    })
    this.stockSevice.getAmount().subscribe(data => {
      this.amounts = data;
      console.log(this.amounts);
    })
    this.stockSevice.getUnit().subscribe(data => {
      this. units = data;
      console.log(this.units);
    });
    this.stockSevice.getStock().subscribe(data => {
      this. stocks = data;
      console.log(this.stocks);
    });

    }

  insert() {
    if (this.productSelect === '' || this.amountSelect === '' || this.unitSelect === '' ||
      this.priceperitem === null || this.totalprice === null || this.date === null || this.note === null) {
      alert('กรุณากรอกข้อมูลให้ครบ');
    }
    else {
      this.httpClient.post('http://localhost:8080/stock/' + this.productSelect + '/'
        + this.amountSelect + '/' + this.unitSelect  + '/' + this.priceperitem + '/' + this.totalprice + '/' + this.date + '/' + this.note, {})
        .subscribe(

          data => {
            console.log('POST Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }

        );
      alert('บันทึกข้อมูลสำเร็จ');
    }
  }
}

