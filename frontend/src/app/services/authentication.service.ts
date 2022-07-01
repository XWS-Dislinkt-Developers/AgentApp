import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { IUser } from '../model/IUser';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
 
  private _accessToken: any;

  constructor(private router: Router, private _http: HttpClient) { }


  login(username: string, password: string) {
    const loginHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    const body = {
      'email': username,
      'password': password
    };

    return this._http.post<any>('http://localhost:8081/auth/login', body, { 'headers': loginHeaders })
    .subscribe(
      response=> {
        console.log(response)
        this._accessToken = response;
        localStorage.setItem("accessToken", response.accessToken)
        localStorage.setItem("role", response.role)
        this.router.navigate(['profile'])
      }

    )
    

  }

    register(user: IUser){
    this._http.post<any>('http://localhost:8081/auth/signup', user ).subscribe(
      response=> {
        console.log(response)
         this.login(user.email, user.password);
      }
    )
   
    }
    signOut() {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("role");
    this.router.navigate([''])
  }
}


