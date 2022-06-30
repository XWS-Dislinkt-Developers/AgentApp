import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CompaniesComponent } from './companies/companies.component';
import { ProfileComponent } from './profile/profile.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { NavBarProfileComponent } from './components/nav-bar-profile/nav-bar-profile.component';
import { JobsComponent } from './jobs/jobs.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CompaniesComponent,
    ProfileComponent,
    NavBarComponent,
    NavBarProfileComponent,
    JobsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
