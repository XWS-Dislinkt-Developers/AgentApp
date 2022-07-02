import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {
  anonymous: boolean = true;

  constructor() { }

  ngOnInit(): void {
    this.whoAmI()
  }
checkCompany(){
  
}
whoAmI(){
  if(localStorage.getItem("accessToken") != null){
    this.anonymous = false;
  }
}

}
