import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-nav-bar-profile',
  templateUrl: './nav-bar-profile.component.html',
  styleUrls: ['./nav-bar-profile.component.css']
})
export class NavBarProfileComponent implements OnInit {


  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }
  signOut(){
    this.authService.signOut()
  }
}
