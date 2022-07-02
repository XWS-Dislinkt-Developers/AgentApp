import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ICompanyRegistrationRequest } from '../model/ICompanyRegistrationRequest';
import { ICompanyRequest } from '../model/ICompanyRequest';


@Injectable({
  providedIn: 'root'
})
export class CompanyService {
 
  constructor(private router: Router, private _http: HttpClient) { }

  headers(){
    return   new HttpHeaders({
      Authorization: "Bearer " + localStorage.getItem("accessToken"),
    });
  }
  getAllRequests(){

    const loginHeaders = new HttpHeaders({
      Authorization: "Bearer " + localStorage.getItem("accessToken"),
    });
    return this._http.get<Observable<ICompanyRegistrationRequest>>('http://localhost:8081/companyRequest/getAll', {'headers': this.headers()}).pipe( )
  }
  
 acceptRequest(id: any) {
  return this._http.post('http://localhost:8081/companyRequest/approveRequest', id, {'headers': this.headers()})
  }

  createCompanyRequest(request: ICompanyRequest) {
    return this._http.post('http://localhost:8081/companyRequest', request, {'headers': this.headers()})
    }
}
