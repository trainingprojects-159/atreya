import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-edit-patient-comp',
  templateUrl: './edit-patient-comp.component.html',
  styleUrls: ['./edit-patient-comp.component.css']
})
export class EditPatientCompComponent implements OnInit {
  appointments: Appointment[];
  doctId: string;
  constructor(private _doctorService: DoctorService) { }

  ngOnInit() {
    this._doctorService.getAppointmentByDoctorId('DR004')
    .then(appointments => this.appointments =appointments);
  }
}