import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminService } from './admin.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { DoctorsComponent } from './doctors/doctors.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { UpdatedoctorComponent } from './updatedoctor/updatedoctor.component';
import { DeletedoctorComponent } from './deletedoctor/deletedoctor.component';
import { UpdatepatientComponent } from './updatepatient/updatepatient.component';
import { GetdoctorbyidComponent } from './getdoctorbyid/getdoctorbyid.component';
import { GetpatientbyidComponent } from './getpatientbyid/getpatientbyid.component';
import { AddreporterComponent } from './addreporter/addreporter.component';
import { UpdateappointmentComponent } from './updateappointment/updateappointment.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent,
    children: [
      {path: 'doctors' , component: DoctorsComponent},
      {path: 'adddoctors' , component: AdddoctorComponent},
      {path: 'updatedoctor/:id' , component: UpdatedoctorComponent},
      {path: 'deletedoctor/:id' , component: DeletedoctorComponent},
      {path: 'updatepatient/:id' , component: UpdatepatientComponent},
      {path: 'doctors/:id' , component: GetdoctorbyidComponent},
      {path: 'patients/:id' , component: GetpatientbyidComponent},
      {path: 'addreporter' , component: AddreporterComponent},
      {path: 'updateappointment' , component: UpdateappointmentComponent},
    ]},
    {path: '' , redirectTo: '/login' , pathMatch: 'full'},
    {path: '**' , component: PagenotfoundComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    DoctorsComponent,
    AdddoctorComponent,
     UpdatedoctorComponent,
    DeletedoctorComponent,
    UpdatepatientComponent,
    GetdoctorbyidComponent,
    GetpatientbyidComponent,
    AddreporterComponent,
    UpdateappointmentComponent,HomeComponent,PagenotfoundComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,HttpModule,RouterModule.forRoot(appRoutes)
  ],
  providers: [AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }

