import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ICompany } from '../model/ICompany';
import { CompanyService } from '../services/company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {
  anonymous: boolean = true;
  companies: any;

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit(): void {
    this.whoAmI()
    this.getAllCompanies()
  
  }
goToCompany(id: any){
  this.router.navigate(['company/'+id]);
}
whoAmI(){
  if(localStorage.getItem("accessToken") != null){
    this.anonymous = false;
  }
}

getAllCompanies(){
this.companyService.getAllCompanies().subscribe( response => {
  this.companies = response;
})
}



}
