import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class JobsService {
  

  constructor( private _http: HttpClient) { }


  getJobsForCompany(id: any){
    return this._http.get('http://localhost:8081/jobOffer/getForCompany/'+ id).pipe()
  }
  getAllJobs(){
    return this._http.get('http://localhost:8081/jobOffer/getAll/').pipe()
  }

  createNewJob(job: any) {
    return this._http.post('http://localhost:8081/jobOffer/save', job, {headers: this.headers()}).pipe()
  }
  headers(){
    return   new HttpHeaders({
      Authorization: "Bearer " + localStorage.getItem("accessToken"),
    });
  }
}
