import { Injectable } from '@angular/core';

import { Headers,Http } from '@angular/http';
import { Doctor } from './doctor'
import { Patient } from './patient';
import { Reporter } from './reporter';
import { Appointment } from './appointment';

 

@Injectable()

export class AdminService {
 
  private url='http://localhost:8090/atreya2/admin';
  private  headers = new Headers({'Content-Type': 'application/json'});
  constructor(private _http: Http) { }
   private handleError(error: any): Promise<any> {

   // console.error('error', error);

    return Promise.reject(error.message || error)

  }
 
  adminlogin(adminid: string, pwd: string): Promise<boolean> {

    const lurl=`${this.url}/login/${adminid}/${pwd}`;

    return this._http.get(lurl, JSON.stringify({adminid: adminid, pwd: pwd}))

    .toPromise()

    .then(response => {

      //const admin = response.json() && response.json().Admin;

      console.log(response.text());

      if ( response.text() === 'true' ) {

        return false;

      } else {

        return true;

      }

    })

    .catch(this.handleError);

  }


  
   addDoctor( doctor: Doctor): Promise<Doctor> {
     return this._http
     .post('http://localhost:8090/atreya2/admin/doctor/add',JSON.stringify(doctor),
     {headers : this.headers})
     .toPromise()
     .then(res => res.json() as Doctor)
     .catch(this.handleError);
    }


    getAllDoctors(): Promise<Doctor[]> {
      return this._http
      .get('http://localhost:8090/atreya2/admin/doctors')
      .toPromise()
      .then(res => res.json() as Doctor[])
      .catch(this.handleError);
    }


    getDoctorById(doctid: string): Promise<Doctor> {
      const lurl= `http://localhost:8090/atreya2/admin/doctor/${doctid}`
      return this._http
      .get(lurl)
      .toPromise()
      .then(res => res.json() as Doctor)
      .catch(this.handleError);
     }


     deleteDoctor(doctid: string): Promise<void> {
       const lurl= `http://localhost:8090/atreya2/admin/doctor/${doctid}`
       return this._http
       .delete(lurl)
       .toPromise()
       .then(res => null)
       .catch(this.handleError);
      }

      updateDoctor(doctid: string,doctor:Doctor): Promise<Doctor> {
        const lurl= `http://localhost:8090/atreya2/admin/doctor/${doctid}`
        return this._http.put(lurl,JSON.stringify(doctor),
        {headers : this.headers})
        .toPromise()
        .then(res => res.json() as Doctor)
        .catch(this.handleError);
       }

       updatePatient(pid: string,patient:Patient): Promise<Patient> {
        const lurl= `http://localhost:8090/atreya2/admin/patient/${pid}`
        return this._http.put(lurl,JSON.stringify(patient),
        {headers : this.headers})
        .toPromise()
        .then(res => res.json() as Patient)
        .catch(this.handleError);
       }
      

       getPatientById(pid: string): Promise<Patient> {
        const lurl= `http://localhost:8090/atreya2/admin/patient/${pid}`
        return this._http
        .get(lurl)
        .toPromise()
        .then(res => res.json() as Patient)
        .catch(this.handleError);
       }

       addReporter( reporter: Reporter): Promise<Reporter> {
        return this._http
        .post('http://localhost:8090/atreya2/admin/reporter/add',JSON.stringify(reporter),
        {headers : this.headers})
        .toPromise()
        .then(res => res.json() as Reporter)
        .catch(this.handleError);
       }

       updateAppointment(appid: string,appointment:Appointment): Promise<Appointment> {
        const lurl= `http://localhost:8090/atreya2/admin/patient/${appid}`
        return this._http.put(lurl,JSON.stringify(appointment),
        {headers : this.headers})
        .toPromise()
        .then(res => res.json() as Appointment)
        .catch(this.handleError);
       }
}