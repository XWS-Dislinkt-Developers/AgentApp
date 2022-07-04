import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ProfileComponent } from './profile/profile.component';
import { CompaniesComponent } from './companies/companies.component';
import { JobsComponent } from './jobs/jobs.component';
import { MyCompaniesComponent } from './my-companies/my-companies.component';
import { CompanyComponent } from './company/company.component';
import { RequestsComponent } from './requests/requests.component';
const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'profile', component: ProfileComponent  },
  { path: 'companies', component: CompaniesComponent  },
  { path: 'jobs', component: JobsComponent  },
  { path: 'my-company', component: MyCompaniesComponent  },
  { path: 'company/:id', component: CompanyComponent  },
  { path: 'requests', component: RequestsComponent  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
