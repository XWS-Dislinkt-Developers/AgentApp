import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { JobsService } from '../services/jobs.service';
import { IJobOfferView } from '../model/IJobOfferView'

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {
  anonymous: boolean= true;
  jobs: any;
  param: string=""

  constructor(private jobService: JobsService) { }

  ngOnInit(): void {
    this.whoAmI()
    this.getAllJobs()
  }
  whoAmI(){
    if(localStorage.getItem("accessToken") != null){
      this.anonymous = false;
    }
}


getAllJobs(){
  this.jobService.getAllJobs().subscribe(res=>{
   this.jobs= res;
   console.log(this.jobs)
  })
}

search(param: string){
  this.jobService.search(param).subscribe(res=> {
    this.jobs=res;
  })
}
}
