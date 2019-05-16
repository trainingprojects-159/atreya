import { Component, OnInit } from '@angular/core';
import { Router, Route } from '../../../node_modules/@angular/router';
import { Reporter } from '../reporter';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-addreporter',
  templateUrl: './addreporter.component.html',
  styleUrls: ['./addreporter.component.css']
})
export class AddreporterComponent implements OnInit {


  public get router(): Router {
    return this._router;
  }
  public set router(value: Router) {
    this._router = value;
  }

  reporter: Reporter =new Reporter;
  routes: Route[];
  

  constructor(private _router: Router, private _adminService : AdminService) { }


  ngOnInit() {
  }
  resetForm():void{

    this.reporter ={
  
      "repid": null,
      "pwd": null
     }
  
  }
  
    addreport():void{
  
      this.reporter ={
  
        "repid": this.reporter.repid,
  
        "pwd":this.reporter.pwd
  
      }
      console.log(this.reporter);
  
      this._adminService.addReporter(this.reporter);
  
      this.resetForm();
  
    }
  
  }
