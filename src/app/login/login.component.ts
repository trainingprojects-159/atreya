import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  admin: Admin=new Admin;
  error ='invalid';
   constructor(private router: Router, private _adminService: AdminService) {}
    
 
   ngOnInit() {
   }
   login(){
  this._adminService.adminlogin(this.admin.adminid, this.admin.pwd)
  .then(result => {
   if(result === true){
     console.log('loggin success');
     localStorage.setItem('adminid',this.admin.adminid);
     this.router.navigateByUrl('home');
   }
   else{
     this.error = 'invalid username and password';
     this.router.navigateByUrl('login');
 
   }
     
   }, error => {this.error = error; });
   return
  
   }
 }