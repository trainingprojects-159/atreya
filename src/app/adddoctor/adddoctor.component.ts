import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { AdminService } from '../admin.service';


import { Router, Route } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {
  doctor: Doctor =new Doctor;
routes: Route[];
doctId: string;



 constructor(private _router: Router, private _adminService : AdminService) { }


  ngOnInit() {
  }
  resetForm():void{

    this.doctor ={
  
      "doctid": null,
      "pwd": null,
      "doctname": null,
      "specialization":null
      }
  
  }
  
  saveDoctor():void{
  
      this.doctor ={
  
        "doctid": this.doctor.doctid,
  
        "pwd":this.doctor.pwd,
        "doctname":this.doctor.doctname,
        "specialization":this.doctor.specialization,
      }
      console.log(this.doctor);
  
      this._adminService.addDoctor(this.doctor);
  
      this.resetForm();
  
    }
}

  

