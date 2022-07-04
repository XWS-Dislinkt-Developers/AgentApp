import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {
  anonymous: boolean= true;

  constructor() { }

  ngOnInit(): void {
    this.whoAmI()
  }
  whoAmI(){
    if(localStorage.getItem("accessToken") != null){
      this.anonymous = false;
    }
}
}
