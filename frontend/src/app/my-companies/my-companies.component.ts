import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ICompany } from '../model/ICompany';
import { CompanyService } from '../services/company.service';
import { ImpresionsService } from '../services/impresions.service';

@Component({
  selector: 'app-my-companies',
  templateUrl: './my-companies.component.html',
  styleUrls: ['./my-companies.component.css']
})
export class MyCompaniesComponent implements OnInit {

    company!: ICompany;
    comments: any;
    salaryAndBenefits: any;
    interviews: any;

  constructor(private companyService: CompanyService,private route: ActivatedRoute, private impresionService: ImpresionsService) { }

  ngOnInit(): void {
    this.getMyCompany();
    
  }

  getMyCompany(){
    this.companyService.showMyCompany().subscribe(res=> {
      this.company = res;
      console.log(this.company)
    })
  }

  showComments(){
    this.impresionService.getCommentsForCompany(this.company.id).subscribe(res=>{
      this.comments = res;
    })
  }
  showSalaryAndBenefits(){
    this.impresionService.getSalaryAndBenefitsForCompany(this.company.id).subscribe(res=>{
      this.salaryAndBenefits = res;
    })
  }
  showInterviews(){
    this.impresionService.getInterviewsForCompany(this.company.id).subscribe(res=>{
      this.interviews = res;
    })
  }
}
