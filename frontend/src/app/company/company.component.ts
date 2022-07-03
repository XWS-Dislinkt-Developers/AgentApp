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
  constructor(private companyService: CompanyService,private route: ActivatedRoute, private impresionService: ImpresionsService,
    private router: Router) { }

  ngOnInit(): void {
    this.whoAmI();
    this.id=Number(this.route.snapshot.paramMap.get('id')); 
    this.showCompany(this.id);

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
  whoAmI(){
    if(localStorage.getItem("accessToken") != null){
      this.anonymous = false;
    }
  }
}
