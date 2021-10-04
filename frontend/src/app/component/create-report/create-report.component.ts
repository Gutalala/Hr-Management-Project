import { Component, OnInit } from '@angular/core';
import { FacilityReport } from 'src/app/models/FacilityReport/facilityreport.model';
import { EhousingService } from 'src/app/service/ehousingService/ehousing-service.service';
import { SessionService } from 'src/app/service/sessionService/session.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-report',
  templateUrl: './create-report.component.html',
  styleUrls: ['./create-report.component.css']
})
export class CreateReportComponent implements OnInit {

  constructor(private ehousingService: EhousingService, private sessionService: SessionService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.report.employee_id = this.sessionService.employee.id;
  }

  statusList = ['Open', 'In Progress', 'Closed'];

  snackBarMessage = 'Your Report Has Been Submitted!';
  snackBarAction = "Close";

  report = new FacilityReport();

  isSuccess = false;

  openSnackBar() {
    this._snackBar.open(this.snackBarMessage, this.snackBarAction);
  }

  createReport(){
    this.report.reportDate = new Date().toISOString().split('T')[0];
    this.report.status = this.statusList[0];
    this.ehousingService.createReport(this.report).subscribe(
      data => {
        console.log(data);
        this.report = new FacilityReport();
      }
    )
  }

}
