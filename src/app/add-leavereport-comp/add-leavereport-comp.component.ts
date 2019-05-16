import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Leavereport } from '../leavereport';

@Component({
  selector: 'app-add-leavereport-comp',
  templateUrl: './add-leavereport-comp.component.html',
  styleUrls: ['./add-leavereport-comp.component.css']
})
export class AddLeavereportCompComponent implements OnInit {
  leaveReport: Leavereport = new Leavereport;
  doctId: string;
  constructor(private _doctorService: DoctorService) { }

  ngOnInit() {
  }

resetForm():void{
  this.leaveReport ={
    "lrid": null,
    "leave_details":null,
    "status":null,
    "doctor":{
      "doctid":null,
      "doctname":"empty",
      "specialization":"none",
      "pwd":"no"
    },
    "reporter":{
      "repid": null,
      "pwd":"no"
    }
  }
}
  addLeavereport():void{
    this.leaveReport ={
      "lrid": this.leaveReport.lrid,
      "leave_details":this.leaveReport.leave_details,
      "status":"applied",
      "doctor":{
        "doctid":this.doctId,
        "doctname":"empty",
        "specialization":"none",
        "pwd":"no"
      },
      "reporter":{
        "repid": "RP777",
        "pwd":"no"
      }
    }
    console.log(this.leaveReport);
    this._doctorService.addLeavereport(this.leaveReport);
    this.resetForm();
  }
}