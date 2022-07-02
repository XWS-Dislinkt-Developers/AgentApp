import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
anonymous: boolean= true;
  constructor() { }

  ngOnInit(): void {
    this.whoAmI();
  }
  
  whoAmI(){
    if(localStorage.getItem("accessToken") != null){
      this.anonymous = false;
    }
  }
}
