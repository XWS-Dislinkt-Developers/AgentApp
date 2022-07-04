import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ICompanyRegistrationRequest } from '../model/ICompanyRegistrationRequest';
import { CompanyService } from '../services/company.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  requests: any 

  constructor(private companyService: CompanyService) { }

  ngOnInit(): void {
    this.getAllRequests()
  }

  getAllRequests(){ 
  
     this.companyService.getAllRequests().subscribe(res=> {
      this.requests= res;
    });
    console.log(this.requests)
  }
  
  accept(id : any){
   var idNew = parseInt(id)
        this.companyService.acceptRequest(idNew).subscribe( res =>{
           this.getAllRequests();
        }
        );
    
  }
}
