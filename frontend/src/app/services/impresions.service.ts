import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ImpresionsService {

  constructor(private router: Router, private _http: HttpClient) { }

  getCommentsForCompany(id: any){
    return this._http.get('http://localhost:8081/comment/getComments/'+ id).pipe()
  }

  saveComment(comment : any){
    return this._http.post('http://localhost:8081/comment/save', comment).pipe()
  }

  getSalaryAndBenefitsForCompany(id: any){
    return this._http.get('http://localhost:8081/salaryAndBenefits/getForCompany/'+ id).pipe()
  }

  saveSalaryAndBenefits(comment : any){
    return this._http.post('http://localhost:8081/salaryAndBenefits/save', comment).pipe()
  }

  getInterviewsForCompany(id: any){
    return this._http.get('http://localhost:8081/interview/getForCompany/'+ id).pipe()
  }

  saveInterview(comment : any){
    return this._http.post('http://localhost:8081/interview/save', comment).pipe()
  }
}


