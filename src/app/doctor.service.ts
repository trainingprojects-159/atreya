import { Injectable } from '@angular/core';
import {Headers, Http } from '@angular/http';
import { Leavereport } from './leavereport';
import { Patient } from './patient';
import { Appointment } from './appointment';

@Injectable()
export class DoctorService {

  private url='http://localhost:8089/Atreya/doctor';
  private  headers = new Headers({'Content-Type': 'application/json'});
  constructor(private _http: Http) { }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error)
  }

  doctorlogin(doctid: string, pwd: string): Promise<boolean> {
    const lurl=`${this.url}/doctorlogin/${doctid}/${pwd}`;
    return this._http.get(lurl, JSON.stringify({doctid: doctid, pwd: pwd}))
    .toPromise()
    .then(response => {
      const doctor = response.json() && response.json().Doctor;
      console.log(response.text());
      if ( response.text() === 'true' ) {
        return false;
      } else {
        return true;
      }
    })
    .catch(this.handleError);
  }

  addLeavereport(leaveReport: Leavereport): Promise<Leavereport> {
    return this._http.post('http://localhost:8089/Atreya/doctor/leavereport/add', JSON.stringify(leaveReport),
    {headers : this.headers})
    .toPromise()
    .then(res => res.json() as Leavereport)
    .catch(this.handleError);
  }

  /** editPatient(pid: string,  patient: Patient): Promise<Patient> {
    return this._http.put(`http://localhost:8089/Atreya/doctor/patient/${pid}`, JSON.stringify(Patient))
    .toPromise()
    .then(res => res.json() as Patient)
    .catch(this.handleError);
  } */

   getAppointmentByDoctorId(doctid: string): Promise<Appointment[]> {
    const lurl = `http://localhost:8089/Atreya/doctor/appointment/${doctid}`
    return this._http
    .get(lurl)
    .toPromise()
    .then(res => res.json() as Appointment[])
    .catch(this.handleError);
  }

  writeReport(doctid: string): Promise<Patient[]> {
    const lurl = `http://localhost:8089/Atreya/doctor/patient/${doctid}`
    return this._http
    .get(lurl)
    .toPromise()
    .then(res => res.json() as Patient[])
    .catch(this.handleError);
  }
}