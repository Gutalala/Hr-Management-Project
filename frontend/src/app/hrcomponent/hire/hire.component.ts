import { Component, OnInit } from '@angular/core';
import {HireService} from "../../service/hire.service"
import {application} from "../../models/application.mode"

@Component({
  selector: 'app-hire',
  templateUrl: './hire.component.html',
  styleUrls: ['./hire.component.css']
})
export class HireComponent implements OnInit {

  
  applications : application[];

  constructor(private dataSerivce: HireService) { }


  ngOnInit() {
    this.getData("getapplications");
  }

  getData(operation:string){

    this.dataSerivce.getData(operation).subscribe(
        (data) =>{
        this.applications = data;
        console.log(this.applications);
        }
    );
  }





}
