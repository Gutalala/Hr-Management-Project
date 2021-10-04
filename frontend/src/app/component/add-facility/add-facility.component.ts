import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { House } from 'src/app/models/House/house.model';
import { HrhousingService } from 'src/app/service/hrHousingService/hrhousing.service';
import { SessionService } from 'src/app/service/sessionService/session.service';

@Component({
  selector: 'app-add-facility',
  templateUrl: './add-facility.component.html',
  styleUrls: ['./add-facility.component.css']
})
export class AddFacilityComponent implements OnInit {

  constructor(private sessionService: SessionService, private _snackBar: MatSnackBar, private hrHousingService: HrhousingService) {}

  ngOnInit(): void {
  }

  newHouse = new House();

  addHouse(){
    this.newHouse.contact.id = 134;
    this.hrHousingService.addHouse(this.newHouse).subscribe();
    this.newHouse = new House();
  }

  openSnackBar() {
    this._snackBar.open("New House and Facility Added", "Close");
  }

}
