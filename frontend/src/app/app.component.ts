import { Component, OnInit } from '@angular/core';
import { Employee } from './models/Employee/employee.model';
import { Contact } from './models/Contact/contact.model';
import { User } from './models/User/user';
import { PersonalDocument } from './models/PersonalDocument/personal-document';
import { EmployeeService } from './service/employeeService/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'my-app';
  employee: Employee;
  // contact = new Contact();
  // contact2 = new Contact();
  // document1 = new PersonalDocument;
  // document2 = new PersonalDocument();
  user: User;
  constructor(private employeeService: EmployeeService){
    
  }

  ngOnInit(){
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.user);
    this.employeeService.getEmployeeByUserid(this.user.id).subscribe(
      (data) => {
        this.employee = data.body;
        console.log(this.employee);
        localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
      }
    );
  }
  // constructor(){
  //   this.user.username = "admin";
  //   this.user.password = "12345";
  //   this.employee.firstName = "John";
  //   this.employee.lastName = "Fang";
  //   this.employee.preferredName = "Zheng";
  //   this.employee.dob = "1996-12-06";
  //   this.employee.gender = "Male";
  //   this.employee.ssn = "123-45-6789";
  //   this.employee.cellphone = "123-456-7890";
  //   this.employee.email = "123@example.com";
  //   this.employee.startDate = "2021-07-23";
  //   this.employee.endDate = "2021-07-24";
  //   this.employee.title = "Mr.";
  //   this.employee.address.addressLine1 = "123 1st Street";
  //   this.employee.address.addressLine2 = "Apat. 123";
  //   this.employee.address.city = "Dream City";
  //   this.employee.address.stateName = "New Jersey";
  //   this.employee.address.stateAbbr = "NJ";
  //   this.employee.address.zipCode = "08888";
  //   this.employee.visaStatus.visaType = "F1/OPT";
  //   this.employee.visaStatus.visaStartDate = "2021-07-21";
  //   this.employee.visaStatus.visaEndDate = "2021-07-22";
  //   this.employee.manager_id = null;
  //   this.contact.firstName = "John";
  //   this.contact.lastName = "Fang";
  //   this.contact.cellphone = "123-456-7891";
  //   this.contact.isEmergency = true;
  //   this.contact2.firstName = "Jenny";
  //   this.contact2.lastName = "Jane";
  //   this.contact2.cellphone = "123-567-8921";
  //   this.contact2.isEmergency = true;
  //   this.employee.contact = [this.contact, this.contact2];
  //   this.document1.filename = "I-20-test.pdf";
  //   this.document2.filename = "I-98-test.pdf";
  //   this.employee.personalDocuments = [this.document1, this.document2];
  //   localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
  //   localStorage.setItem('currentUser', JSON.stringify(this.user));
  // }
}
