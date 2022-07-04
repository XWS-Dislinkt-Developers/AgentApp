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

  constructor(private companyService: CompanyService,private route: ActivatedRoute, private impresionService: ImpresionsService, private jobService : JobsService ) { }

  ngOnInit(): void {
    this.getMyCompany();
    
  }

  getMyCompany(){
    this.companyService.showMyCompany().subscribe(res=> {
      this.company = res;
      console.log(this.company)
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
}
