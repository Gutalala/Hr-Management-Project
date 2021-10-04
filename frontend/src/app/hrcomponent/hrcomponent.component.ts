import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hrcomponent',
  templateUrl: './hrcomponent.component.html',
  styleUrls: ['./hrcomponent.component.css']
})
export class HrcomponentComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  logout(){
    localStorage.removeItem('currentUser');
    localStorage.removeItem('currentEmployee');
    this.router.navigate(['/'])
    .then(() => {
      window.location.reload();
    });
  }
}
