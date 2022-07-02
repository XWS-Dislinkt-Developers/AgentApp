import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/model/IUser';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  username: string='';
  password: string='';
  user : IUser={
    name: '',
    password: '',
    email: '',
    street: '',
    country: '',
    city: '',
    role: 'ROLE_USER',
    number: '',
    telephone: '',
    surname: ''
  };
  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  logIn(username :string, password: string){
    this.authService.login(username, password)
  }

  registration(user: IUser){
    this.authService.register(user)
  }


}
