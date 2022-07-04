import { Component, OnInit } from '@angular/core';
import { ICompanyRequest } from 'src/app/model/ICompanyRequest';
import { INewComment } from 'src/app/model/INewComment';
import { INewInterview } from 'src/app/model/INewInterview';
import { INewSalaryAndBenefits } from 'src/app/model/INewSalaryAndBenefits';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompanyService } from 'src/app/services/company.service';
import { ImpresionsService } from 'src/app/services/impresions.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar-profile',
  templateUrl: './nav-bar-profile.component.html',
  styleUrls: ['./nav-bar-profile.component.css']
})
export class NavBarProfileComponent implements OnInit {
admin: boolean = false;
owner: boolean=false;
  request: any= 
  {
    logo: '',
    name: '',
    yearOfOpening: '',
    offices: [],
    description: '',
    positions: [],
    numberOfEmployees: ''
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
  salaryAndBenefits: INewSalaryAndBenefits={
    companyId: undefined,
    position: '',
    salary: 0,
    benefits: [],
    levelOfExperience: undefined,
    engagement: undefined
  }

  interview: INewInterview={
    idCompany: undefined,
    yearOfInterview: '',
    position: '',
    HRInterview: '',
    technicalInterview: '',
    interviewDifficulty: '',
    offerStatus: '',
    title: ''
  }
  
  office : string='';
  position: string='';
  name: string=""

  // convert image
  isImageSaved: boolean = false;
  cardImageBase64: string = '';
  company: any;

  constructor(private authService: AuthenticationService,private companyService: CompanyService, private impresionService: ImpresionsService) { }

  ngOnInit(): void {
    this.whoAmI()
  }

  whoAmI(){
    if(localStorage.getItem("role") =="ROLE_ADMIN"){
      this.admin = true;
    }
    if(localStorage.getItem("role") =="ROLE_COMPANY_OWNER"){
      this.owner = true;
    }
  }
  signOut(){
    this.authService.signOut()
  }
  search(searchValue: any){
    console.log(searchValue)
  this.companyService.searchCompany(searchValue).subscribe( response => {
    this.company = response;
    this.comment.companyId = this.company[0].id;
    this.salaryAndBenefits.companyId = this.company[0].id;
    this.interview.idCompany = this.company[0].id
  })
  }
  companyRegistration(){
    console.log(this.request)
   this.companyService.createCompanyRequest(this.request).subscribe(
    response=> {
       Swal.fire('success', 'You sent request for company registration!');
       console.log(response)
    }
   )

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
setDifficulty(number: any){
  console.log(number)
  this.interview.interviewDifficulty = number
}
setStatus(number: any){
  console.log(number)
  this.interview.offerStatus = number
}
createSalaryAndBenefit(salaryAndBen : INewSalaryAndBenefits){
  this.salaryAndBenefits.engagement = parseInt(salaryAndBen.engagement);
  this.salaryAndBenefits.levelOfExperience = parseInt(salaryAndBen.levelOfExperience)
 
  console.log(this.salaryAndBenefits)
  this.impresionService.saveSalaryAndBenefits(this.salaryAndBenefits).subscribe( response=> {
Swal.fire("success","Your comment is added");
  },
  err => {
Swal.fire("opssss...","Something went wrong")
  })
}

createInterview(interview: INewInterview){
  console.log(this.interview)
  this.impresionService.saveInterview(this.interview).subscribe( response=> {
    Swal.fire("success","Your interview  is added");
      },
      err => {
    Swal.fire("opssss...","Something went wrong")
      })
}
  addOffice(office: string){
    this.request.offices.push(office);
    this.office =""
  }
  addPosition(position: string){
    this.request.positions.push(position);
    this.position =""
  }
  CreateBase64String(fileInput: any) {
    if (fileInput.target.files && fileInput.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const image = new Image();
        image.src = e.target.result;
        image.onload = rs => {
          const imgBase64Path = e.target.result;
          this.cardImageBase64 = imgBase64Path;         
          this.isImageSaved = true;
          console.log(imgBase64Path);
          this.request.logo = imgBase64Path;
        };
      };
      reader.readAsDataURL(fileInput.target.files[0]);
    }
  }

handleBenefit(benefit: string){
  console.log(benefit)
  this.salaryAndBenefits.benefits.push(benefit);
  console.log("dodao sam benefit")

}

 setCompanyId(c : any){
  alert(c)
  alert(c.id)
  this.comment.companyId =c.id;
 }
}
