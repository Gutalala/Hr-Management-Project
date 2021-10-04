import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hrhousing',
  templateUrl: './hrhousing.component.html',
  styleUrls: ['./hrhousing.component.css']
})
export class HrhousingComponent implements OnInit {

  constructor() { }

  isAdd: boolean;
  isView: boolean;
  isDelete: boolean;

  ngOnInit(): void {
  }

  addSwitch(){
    this.isAdd = true;
    this.isView = false;
    this.isDelete = false;
  }

  viewSwitch(){
    this.isAdd = false;
    this.isView = true;
    this.isDelete = false;
  }

  deleteSwitch(){
    this.isAdd = false;
    this.isView = false;
    this.isDelete = true;
  }

  


  

}
