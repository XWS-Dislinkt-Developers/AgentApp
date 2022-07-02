import { Component, OnInit } from '@angular/core';
import { ICompanyRequest } from 'src/app/model/ICompanyRequest';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompanyService } from 'src/app/services/company.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar-profile',
  templateUrl: './nav-bar-profile.component.html',
  styleUrls: ['./nav-bar-profile.component.css']
})
export class NavBarProfileComponent implements OnInit {
admin: boolean = false;
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
  request2: ICompanyRequest= 
  {
    logo: '',
    name: '',
    yearOfOpening: '',
    offices: [],
    description: '',
    positions: [],
    numberOfEmployees: ''
  };
  office : string='';
  position: string='';

// convert image
isImageSaved: boolean = false;
cardImageBase64: string = '';

  constructor(private authService: AuthenticationService,private companyService: CompanyService) { }

  ngOnInit(): void {
    this.whoAmI()
  }

  whoAmI(){
    if(localStorage.getItem("role") =="ROLE_ADMIN"){
      this.admin = true;
    }
  }
  signOut(){
    this.authService.signOut()
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

 
}
