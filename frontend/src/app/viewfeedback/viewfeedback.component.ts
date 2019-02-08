import { Component, OnInit } from '@angular/core';
import { Allservice2Service } from '../service/allservice2.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewfeedback',
  templateUrl: './viewfeedback.component.html',
  styleUrls: ['./viewfeedback.component.css']
})
export class ViewfeedbackComponent implements OnInit {

  feedback: Array<any>;

  constructor(private allservice2: Allservice2Service , private httpClient: HttpClient, private router: Router) { }


  ngOnInit() {
    this.allservice2.getFeedback().subscribe(data => {
      this.feedback = data;
      console.log(this.feedback);
    });
  }

}
