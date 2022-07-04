import { Component, OnInit } from '@angular/core';
import { INewComment } from 'src/app/model/INewComment';
import { IUser } from 'src/app/model/IUser';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompanyService } from 'src/app/services/company.service';
import { ImpresionsService } from 'src/app/services/impresions.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  username: string='';
  name: string=''
  password: string='';
  company: any;
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
  comment: INewComment ={
    companyId: undefined,
    position: '',
    currentlyEmployed: false,
    positive: '',
    negative: '',
    projects: '',
    grade: undefined,
    levelOfExperience: undefined,
    engagement: undefined,
    title: ''
  }

  constructor(private authService: AuthenticationService, private companyService: CompanyService, private impresionService: ImpresionsService) { }

  ngOnInit(): void {
  }

  logIn(username :string, password: string){
    this.authService.login(username, password)
  }

  registration(user: IUser){
    this.authService.register(user)
  }

search(searchValue: any){
  console.log(searchValue)
this.companyService.searchCompany(searchValue).subscribe( response => {
  this.company = response;
})
}

searchCompany(name : string){
  alert("ej")
  this.companyService.searchCompany(name).subscribe( response=>{
    this.company = response;
  })
}

createComment(comment : any){
  this.comment.grade= parseFloat(comment.grade);
  this.comment.engagement = parseInt(comment.engagement);
  this.comment.levelOfExperience = parseInt(comment.levelOfExperience)
  this.comment.companyId = parseInt(comment.companyId)
  if(comment.currentlyEmployed == "true"){
    this.comment.currentlyEmployed =true;
  }else {
    this.comment.currentlyEmployed=false;
  }
  console.log(this.comment)
  this.impresionService.saveComment(this.comment).subscribe( response=> {
Swal.fire("Your comment is added", "success");
  },
  err => {
Swal.fire("Something went wrong", "opssss...")
  })
}
}
