import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HireService } from 'src/app/service/hire.service';

@Component({
  selector: 'app-generatetoken',
  templateUrl: './generatetoken.component.html',
  styleUrls: ['./generatetoken.component.css']
})
export class GeneratetokenComponent implements OnInit {

  generatetokenform = this.formBuilder.group({
    email: '' 
   
  });

  constructor(private formBuilder: FormBuilder, private route: ActivatedRoute,
    private router: Router, private hireservice: HireService) { }

  ngOnInit(): void {
  }


  onSubmit(): void {
   
    // console.log(   this.generatetokenform.get("email") );
    // let tempemail = '';

    // this.hireservice.sendTokenEmail(this.generatetokenform.value.email).subscribe(data=>{

    //     tempemail = data;

    // });

    if(this.generatetokenform.value.email != undefined && this.generatetokenform.value.email.length >0){

      console.warn('The token has been sent!', this.generatetokenform.value.email );
    }

    this.hireservice.sendTokenEmail(this.generatetokenform.value.email).subscribe(

      data=> console.log(data)

    );


    this.generatetokenform.reset();
  

      // this.hireservice.sendTokenEmail(this.generatetokenform.value.email, )
      
       //this.router.navigate(["changtosignuplink", this.tokenform.get("token")]);
   
  }

}
