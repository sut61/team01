import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ManuService } from '../service/manu.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manu',
  templateUrl: './manu.component.html',
  styleUrls: ['./manu.component.css']
})
export class ManuComponent implements OnInit {

manuadd: any = {
  inputName: '',
  inputPrice: ''
}
  manu: Array<any>;
  manuts: Array <any>;
  coffees: Array <any>;
  bakerys: Array <any>;

  manutypeSelect: number = 0;
  coffeetypeSelect:number = 0;
  bakerytypeSelect: number = 0;


  constructor(private manuService: ManuService,
              private httpClient: HttpClient,
              private router: Router) { }

  ngOnInit() {
    this.manuService.getManuType().subscribe(data => {
      this.manuts = data;
      console.log(this.manuts);
    });
    this.manuService.getCoffeeType().subscribe(data => {
      this.coffees = data;
      console.log(this.coffees);
    });
    this.manuService.getBakerType().subscribe(data => {
      this.bakerys = data;
      console.log(this.bakerys);
    });
  }
  save() {
    if (this.manutypeSelect === 0 && this.manuadd.inputName === '' || this.coffeetypeSelect === 0  ||
      this.bakerytypeSelect === 0 && this.manuadd.inputPrice === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/manu/' + this.manutypeSelect + '/' +
        this.coffeetypeSelect + '/' + this.bakerytypeSelect + '/' , this.manuadd)
        .subscribe(

          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }

        );
      alert('บันทึกข้อมูลสำเร็จ');
    }
  }
}
