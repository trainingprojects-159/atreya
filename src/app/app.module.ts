import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DoctorService } from './doctor.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeCompComponent } from './home-comp/home-comp.component';
import { AddLeavereportCompComponent } from './add-leavereport-comp/add-leavereport-comp.component';
import { EditPatientCompComponent } from './edit-patient-comp/edit-patient-comp.component';
import { PageNotFoundCompComponent } from './page-not-found-comp/page-not-found-comp.component';
import { WritereportComponent } from './writereport/writereport.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeCompComponent, 
    children: [
      { path: 'addleavereport', component: AddLeavereportCompComponent },
      { path: 'editpatient', component: EditPatientCompComponent },
      { path: 'writereport', component: WritereportComponent}
    ] },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: PageNotFoundCompComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    HomeCompComponent,
    AddLeavereportCompComponent,
    EditPatientCompComponent,
    PageNotFoundCompComponent,
    WritereportComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [DoctorService],
  bootstrap: [AppComponent]
})
export class AppModule { }