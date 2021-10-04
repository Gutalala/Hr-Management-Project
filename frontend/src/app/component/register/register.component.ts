import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HireService } from 'src/app/service/hire.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error:string = '';

  tokenform = this.formBuilder.group({
    token: '' 
   
  });

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute,
    private router: Router,private hireservice: HireService) { }

  ngOnInit(): void {


  }



  onSubmit(): void {

    this.hireservice.validateToken( this.tokenform.value.token).subscribe(data=>{

      this.error = '';

      if(data == 200){
        console.log(this.tokenform.value.token);
        this.router.navigate(["CreateAccount/", this.tokenform.value.token]);
      }

      if(data == 404){
        this.error = "The token cannot be found!";
      }

      if(data == 503){
        this.error = "Token already expired!";
      }


  });
   
    //console.log(   this.tokenform.get("token") );

    //console.warn('validating', this.tokenform.value );
   
   //  this.router.navigate(["changtosignuplink", this.tokenform.get("token")]);

  }

}
