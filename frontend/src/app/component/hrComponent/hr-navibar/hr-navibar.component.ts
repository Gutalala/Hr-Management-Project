import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hr-navibar',
  templateUrl: './hr-navibar.component.html',
  styleUrls: ['./hr-navibar.component.css']
})
export class HrNavibarComponent implements OnInit {

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
