import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ICompany } from '../model/ICompany';
import { CompanyService } from '../services/company.service';
import { ImpresionsService } from '../services/impresions.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
anonymous: boolean= true;
id : number =0;
  company!: ICompany;
  comments: any;
  salaryAndBenefits: any
  interviews: any

  constructor(private companyService: CompanyService,private route: ActivatedRoute, private impresionService: ImpresionsService,
    private router: Router) { }

  ngOnInit(): void {
    this.whoAmI();
    this.id=Number(this.route.snapshot.paramMap.get('id')); 
    this.showCompany(this.id);
    this.showInterviews()
    this.showSalaryAndBenefits()
    

  }
  showCompany(id: any){
    this.companyService.showCompany(id).subscribe(response=>{
      this.company=response;
    })
  }

  showComments(){
    this.impresionService.getCommentsForCompany(this.id).subscribe( results=> {
    this.comments= results;
    })
  }
  showSalaryAndBenefits(){
    this.impresionService.getSalaryAndBenefitsForCompany(this.id).subscribe( results=> {
    this.salaryAndBenefits= results;
    })
  }
  showInterviews(){

    this.impresionService.getInterviewsForCompany(this.id).subscribe( results=> {
    this.interviews= results;
    console.log(this.interviews[0])
    })
  }
  whoAmI(){
    if(localStorage.getItem("accessToken") != null){
      this.anonymous = false;
    }
  }
}
