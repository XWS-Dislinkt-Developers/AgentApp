import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CompaniesComponent } from './companies/companies.component';
import { ProfileComponent } from './profile/profile.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { NavBarProfileComponent } from './components/nav-bar-profile/nav-bar-profile.component';
import { JobsComponent } from './jobs/jobs.component';
import { MyCompaniesComponent } from './my-companies/my-companies.component';
import { CompanyComponent } from './company/company.component';
import { RequestsComponent } from './requests/requests.component';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CompaniesComponent,
    ProfileComponent,
    NavBarComponent,
    NavBarProfileComponent,
    JobsComponent,
    MyCompaniesComponent,
    CompanyComponent,
    RequestsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
 
 

  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
