import { Component, OnInit } from '@angular/core';
import { TokenApiService } from 'src/app/service/token-api/token-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/User/user';
import { UserService } from 'src/app/service/userService/user-service.service';

@Component({
  selector: 'app-account-creation',
  templateUrl: './account-creation.component.html',
  styleUrls: ['./account-creation.component.css']
})
export class AccountCreationComponent implements OnInit {

  constructor(private tokenService: TokenApiService, private route: ActivatedRoute, private userService: UserService, private router: Router ) { }

  token: string;
  user = new User();

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.token = params['token'];
        console.log(params['token']);
      }
    );

    this.tokenService.getToken(this.token).subscribe(data => {
       this.user.email = data.body.registrationToken.email;
    });
  }

  postUser(){
    this.user.createDate = new Date().toISOString().slice(0, 19).replace('T', ' ');
    console.log(this.user.createDate);

    this.userService.addUser(this.user).subscribe(
      data => {
        this.userService.user_id = data.body;
        console.log(this.userService.user_id);
      }
    );

    this.userService.email = this.user.email;

    this.router.navigate(['/onboarding']);
  }

}
