import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpServiceService } from 'src/app/service/httpService/http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  returnurl: string;
  error:{};
  loginError: string;

  constructor(
    private httpService: HttpServiceService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.httpService.logout();
  }

  get username(){ return this.loginForm.get('username');}
  get password(){ return this.loginForm.get('password');}

  onSubmit(){
    this.loginError = '';
    this.httpService.login(this.username.value, this.password.value).subscribe(
      (data) => {
        console.log('currentUser:' + localStorage.getItem('currentUser'));
        if (this.httpService.isLoggedIn()){
          this.loginError = 'Redirecting';
          const redirect = this.httpService.redirectUrl ? this.httpService.redirectUrl : '/';
          console.log("redirect: " + redirect);
          this.router.navigate([redirect]);
        } else {
          this.loginError = localStorage.getItem('message');
        }
      },
      error => this.error = error
    );
  }
}
