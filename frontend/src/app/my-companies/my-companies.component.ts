import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { ICompany } from '../model/ICompany';
import {  INewJobOffer } from '../model/INewJobOffer';
import { CompanyService } from '../services/company.service';
import { ImpresionsService } from '../services/impresions.service';
import { JobsService } from '../services/jobs.service';

@Component({
  selector: 'app-my-companies',
  templateUrl: './my-companies.component.html',
  styleUrls: ['./my-companies.component.css']
})
export class MyCompaniesComponent implements OnInit {

    company!: ICompany;
    comments: any;
    salaryAndBenefits: any;
    interviews: any;
    jobs: any;
    skilName: string=''
    newJob: INewJobOffer={
      position: '',
      jobDescription: '',
      dailyActivities: '',
      levelOfExperience: undefined,
      engagement: undefined,
      benefits: [],
      requirements: [],
      expires: undefined,
      promoteOnDislinkt: false
    };
office: string=""
position: string=""
  constructor(private companyService: CompanyService,private route: ActivatedRoute, private impresionService: ImpresionsService, private jobService : JobsService ) { }

  ngOnInit(): void {
    this.getMyCompany();
    
  }

  getMyCompany(){
    this.companyService.showMyCompany().subscribe(res=> {
      this.company = res;
    })
  }

  showComments(){
    this.impresionService.getCommentsForCompany(this.company.id).subscribe(res=>{
      this.comments = res;
    })
  }
  showSalaryAndBenefits(){
    this.impresionService.getSalaryAndBenefitsForCompany(this.company.id).subscribe(res=>{
      this.salaryAndBenefits = res;
    })
  }
  showInterviews(){
    this.impresionService.getInterviewsForCompany(this.company.id).subscribe(res=>{
      this.interviews = res;
    })
  }

  showJobs(){
   
    this.jobService.getJobsForCompany(this.company.id).subscribe(res=>{
      this.jobs = res;
       console.log(this.jobs)
    })
  }

  handleBenefit(benefit: string){
    console.log(benefit)
    this.newJob.benefits.push(benefit);
    console.log("dodao sam benefit")
  
  }

  addSkils(skil: string){
    this.newJob.requirements.push(skil);
  }
  promote(){
    this.newJob.promoteOnDislinkt=true;
    
  }
  createJob(job: any){
    this.newJob.levelOfExperience = parseInt(job.levelOfExperience);
    this.jobService.createNewJob(this.newJob).subscribe(res=> {
      Swal.fire("success", "You created new job offer.");
      this.showJobs();
    },
    err=> {
      Swal.fire("oppsss", "You didn't create job offer. Try again.")
    })
  }

  addOffice(office: string){
    this.company.offices.push(office)
  }

  remove(index: any){
    this.company.offices.splice(index, 1);
  }

  addPosition(pos: string){

  }
  removePosition(position: any){}

  editCompany(){
    console.log(this.company)
    return this.companyService.editCompany(this.company).subscribe( res => { this.company = res;})
  }

  CreateBase64String(fileInput: any) {
    if (fileInput.target.files && fileInput.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const image = new Image();
        image.src = e.target.result;
        image.onload = rs => {
          const imgBase64Path = e.target.result;
          console.log(imgBase64Path);
          this.company.logoImage = imgBase64Path;
        };
      };
      reader.readAsDataURL(fileInput.target.files[0]);
    }
  }
}
