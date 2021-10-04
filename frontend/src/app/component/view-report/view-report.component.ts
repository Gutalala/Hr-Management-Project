import { Component, Input, OnInit } from '@angular/core';
import { EhousingService } from 'src/app/service/ehousingService/ehousing-service.service';
import { SessionService } from 'src/app/service/sessionService/session.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import { FacilityReport } from 'src/app/models/FacilityReport/facilityreport.model';
import { EmployeeService } from 'src/app/service/employeeService/employee.service';
import { Facilityreportdetail } from 'src/app/models/FacilityReportDetail/facilityreportdetail.model';
import { Facility } from 'src/app/models/Facility/facility.model';

@Component({
  selector: 'app-view-report',
  templateUrl: './view-report.component.html',
  styleUrls: ['./view-report.component.css']
})
export class ViewReportComponent implements OnInit {

  constructor(private employeeService: EmployeeService, private ehousingService: EhousingService, private sessionService: SessionService, private _snackBar: MatSnackBar) { }

  reportList: FacilityReport[];

  currReport = new FacilityReport();

  commentList: Facilityreportdetail[];

  isAddComment = false;
  isReportList = true;
  isViewComment = false;

  newComment = new Facilityreportdetail();

  addCommentSnackBar() {
    this._snackBar.open('Your Comment Has Been Submitted!', "Close");
  }



  addCommentCheck(){
    this.isReportList = false;
    this.isAddComment = true;
  }

  viewCommentCheck(){
    this.isReportList = false;
    this.isViewComment = true;
  }

  ngOnInit(): void {
    this.ehousingService.viewReport(this.sessionService.employee.house_id).subscribe(
      data => {
        this.reportList = data.body;
        console.log(data.body);
      }
    )
  }

  viewComment(){
    this.ehousingService.viewComment(this.currReport.id).subscribe(
      data => {
        this.commentList = data.body;
        console.log(data.body);
      }
    )
  }

  cancelComment(){
    this.isAddComment = false;
    this.isReportList = true;
  }

  addComment(){
    this.newComment.createdDate = new Date().toISOString().split('T')[0];
    this.newComment.employee_id = this.currReport.employee_id;
    this.newComment.facilityReport_id = this.currReport.id;
    this.ehousingService.addComment(this.newComment).subscribe();
    this.isAddComment = false;
    this.isReportList = true;
  }

  updateableCheck(comment: Facilityreportdetail){
    if (comment.employee_id == this.currReport.employee_id){
      return false;
    }
    else
      return true;
  }

  updateComment(comment: Facilityreportdetail){
    comment.lastModificationDate = new Date().toISOString().split('T')[0];
    this.ehousingService.updateComment(comment).subscribe();
    this.isViewComment = false;
    this.isReportList = true;
  }

  updateCommentSnackBar(){
    this._snackBar.open('Your Comment Has Been Updated!', "Close");
  }

  dateFilter(comment: Facilityreportdetail){
    if (!comment.lastModificationDate)
      return comment.createdDate;
    else
      return comment.lastModificationDate;
  }



}
