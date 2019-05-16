import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { AdminService } from '../admin.service';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {
  doctors: Doctor[];
  constructor(private _adminService: AdminService,private router: Router) { }

  ngOnInit() {
    this._adminService.getAllDoctors().then(doctors => this.doctors = doctors);
  }
  delete(doctid:string):void{
    this._adminService.deleteDoctor(doctid);
  }

}
