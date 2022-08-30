import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http: HttpClient) { }

  addPromotionToken(token: string){
    return this._http.post('http://localhost:8090/user/addToken', {"token":token}, {headers: this.headers()})
  }
  
  headers(){
    return new HttpHeaders({
      Authorization: "Bearer " + localStorage.getItem("accessToken"),
    });
  }
}