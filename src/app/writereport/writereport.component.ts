import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-writereport',
  templateUrl: './writereport.component.html',
  styleUrls: ['./writereport.component.css']
})
export class WritereportComponent implements OnInit {

  patients: Patient[];
  patientId: string;
  constructor(private _doctorService: DoctorService) { }

  ngOnInit() {
    this._doctorService.writeReport(this.patientId)
    .then(patients => this.patients = patients);
  }
}