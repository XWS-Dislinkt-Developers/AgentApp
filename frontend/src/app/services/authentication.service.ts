import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { IUser } from '../model/IUser';
import Swal from 'sweetalert2';

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

    return this._http.post<any>('http://localhost:8090/auth/login', body, { 'headers': loginHeaders })
    .subscribe(
      response=> {
        console.log(response)
        this._accessToken = response;
        localStorage.setItem("accessToken", response.accessToken)
        localStorage.setItem("role", response.role)
        this.router.navigate(['profile'])
      }, 
      err=> {
        Swal.fire("ooopss...", "Wrong credentials. Try again.")
      }

    )
  }

    register(user: IUser){
    this._http.post<any>('http://localhost:8090/auth/signup', user ).subscribe(
      response=> {
        console.log(response)
       //this.login(user.email, user.password);
       Swal.fire("success", "You successfully registrated! You can sign in now.")
      },
      err=> {
        Swal.fire("ooppsss...", "This username is already taken! Try again")
      }
    )
   
    }
    signOut() {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("role");
    this.router.navigate([''])
  }
}

