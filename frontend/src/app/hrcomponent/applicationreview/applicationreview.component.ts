import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HireService} from "../../service/hire.service"
import  { applicationDetails} from "../../models/applicationdetails.model"
import { comment } from "../../models/comment.model"

@Component({
  selector: 'app-applicationreview',
  templateUrl: './applicationreview.component.html',
  styleUrls: ['./applicationreview.component.css']
})
export class ApplicationreviewComponent implements OnInit {

  employeeId: Number;

  employeeDetails : applicationDetails;

  thecomment : comment =  new comment();
  comments : string ='';

  constructor(private _Activatedroute:ActivatedRoute, private dataSerivce: HireService) { }

  ngOnInit() {
    this.getParam();
    this.getEmployeeData(this.employeeId);
   

  }

  getParam() {

      this._Activatedroute.paramMap.subscribe(params => { 
        this.employeeId = +params.get('empid'); 
      });
      console.log(this.employeeId);

  }

  getEmployeeData(empid: any) {

              this.dataSerivce.getFullEmployeeData(empid).subscribe(

                        (data) =>{

                      this.employeeDetails = new applicationDetails(
                      data.employee.firstName,  data.employee.lastName,
                      data.employee.middleName, data.employee.preferedName,
                      data.employee.avatar, data.address.addressLine1,
                      data.address.addressLine2, data.address.city, data.address.stateAbbr,
                      data.address.zipcode,  data.employee.car,  data.employee.email,
                      data.employee.ssn,  data.employee.dob,  data.employee.gender,
                      data.visatype,  data.employee.driverLicense,  data.reference, data.contacts
                      
                      );

                          
                            console.log(data);
                            console.log(data.employee.firstName);

                            console.log(this.employeeDetails);


                        }

              )
    }

    submitted = false;
    onSubmit(){

        this.submitted = true; 
      console.log(this.thecomment.firstName);
      console.log(this.thecomment.lastName);
      console.log(this.thecomment.middleName);
      console.log(this.thecomment.preferredName);
    }

    

    approve(){
            let thekey: keyof comment;
            for (  thekey in this.thecomment) {
                    if (this.thecomment.hasOwnProperty(thekey)) {
                    
                    if(this.thecomment[thekey] !== undefined){
                      this.comments =  this.comments +  this.thecomment[thekey] + ',';
                   }
 
                     }


            }   

 
      


            console.log("comments : " + this.comments);
            console.log(this.employeeId);
            this.dataSerivce.approveEmployeyApplication(this.employeeId, this.comments).subscribe(data=>{console.log(data)});

              console.log("application approved!");
    }




    reject(){
      let thekey: keyof comment;
      for (  thekey in this.thecomment) {
              if (this.thecomment.hasOwnProperty(thekey)) {
              
              if(this.thecomment[thekey] !== undefined){
                this.comments =  this.comments +  this.thecomment[thekey] + ',';
             }

               }


      }   

      console.log("comments : " + this.comments);
      console.log(this.employeeId);
      this.dataSerivce.rejectEmployeyApplication(this.employeeId, this.comments).subscribe(data=>{console.log(data)});


   
      console.log("application rejected!");
    }

     
  }

 