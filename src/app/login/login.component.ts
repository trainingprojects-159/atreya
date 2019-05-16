import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  doctor: Doctor=new Doctor;
  error = 'invalid';

  constructor(private router: Router,
    private _doctorService: DoctorService) { }

  ngOnInit() {
  }

  doctorlogin() : void {
    this._doctorService.doctorlogin(this.doctor.doctid, this.doctor.pwd)
    .then( 
      result => {
      if (result === true ) {
        console.log( 'Login Success' );
        this.router.navigateByUrl('home');
      } else {
        this.error = 'Invalid Doctor ID and Password';
        this.router.navigateByUrl('login');
      }
    }, error => { this.error = error; });
  }
}