import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { User } from 'src/app/models/User/user';
import { Employee } from 'src/app/models/Employee/employee.model';
import { AddressService } from 'src/app/service/addressService/address.service';
import { ContactService } from 'src/app/service/contactService/contact.service';
import { EmployeeService } from 'src/app/service/employeeService/employee.service';
import { PersonalDocumentService } from 'src/app/service/personalDocumentService/personal-document.service';
import { VisaStatusService } from 'src/app/service/visaStatusService/visa-status.service';
import { Contact } from 'src/app/models/Contact/contact.model';
import { Address } from 'src/app/models/Address/address.model';
import { VisaStatus } from 'src/app/models/VisaStatus/visa-status.model';
import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { PersonalDocument } from 'src/app/models/PersonalDocument/personal-document';
import { FileRetrieveService } from 'src/app/service/fileRetrieveService/file-retrieve.service';
import { Observable } from 'rxjs';


export const MY_FORMATS = {
  parse: {
    dateInput: 'LL',
  },
  display: {
    dateInput: 'MM-DD-YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY'
  },
};

@Component({
  selector: 'app-personal-information',
  templateUrl: './personal-information.component.html',
  styleUrls: ['./personal-information.component.css'],
  providers: [
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ]
})
export class PersonalInformationComponent implements OnInit {

  // toggle buttons
  showNameFormBtn: boolean;
  showContactFormBtn: boolean;
  showAddressFormBtn: boolean;
  showVisaStatusFormBtn: boolean;
  showEmergencyContactFormBtn: boolean;

  // toggle forms
  showNameForm: boolean;
  showContactForm: boolean;
  showAddressForm: boolean;
  showVisaStatusForm: boolean;
  showEmergencyContactForm: boolean;

  // form groups
  employeeForm: FormGroup;
  contactForm: FormGroup;
  addressForm: FormGroup;
  visaStatusForm: FormGroup;
  emergencyContactForm: FormGroup;

  // form arrays
  emergencyContacts: FormArray;

  // cridentials
  user: User;
  currentTime: Date;
  employee: Employee;
  documents: PersonalDocument[];
  fileUploads: Observable<any>;
  
  // demos
  contact = new Contact();
  contact2 = new Contact();
  
  // visa types
  workAuthControl = new FormControl('', Validators.required);
  workAuth = ['H1-B', 'L2', 'F1(CPT/OPT)', 'H4', 'Other'];

  constructor(
    private employeeService: EmployeeService,
    private addressService: AddressService,
    private visaStatusService: VisaStatusService,
    private contactService: ContactService,
    private fileRetrieveService: FileRetrieveService,
    private formBuilder: FormBuilder
  ) {
    // get employee information
    this.employee = JSON.parse(localStorage.getItem('currentEmployee'));

    // demo employee

    // set default toggle buttons
    this.showNameFormBtn = true;
    this.showContactFormBtn = true;
    this.showAddressFormBtn = true;
    this.showVisaStatusFormBtn = true;
    this.showEmergencyContactFormBtn = true;

    // set default form buttons
    this.showNameForm = false;
    this.showContactForm = false;
    this.showAddressForm = false;
    this.showVisaStatusForm = false;
    this.showEmergencyContactForm = false;

    // build forms
    this.employeeForm = this.formBuilder.group({
      firstName: [this.employee.firstName, Validators.required],
      lastName: [this.employee.lastName, Validators.required],
      preferredName: [this.employee.preferredName],
      dob: [this.employee.dob, Validators.required]
    });
    this.contactForm = this.formBuilder.group({
      personalEmail: [this.employee.email, Validators.required],
      cellphone: [this.employee.cellphone, Validators.required]
    });
    this.addressForm = this.formBuilder.group({
      addressLine1: [this.employee.address.addressLine1, Validators.required],
      addressLine2: [this.employee.address.addressLine2],
      city: [this.employee.address.city, Validators.required],
      stateName: [this.employee.address.stateName, Validators.required],
      stateAbbr: [this.employee.address.stateAbbr, Validators.required],
      zipCode: [this.employee.address.zipCode, Validators.required]
    });
    this.visaStatusForm = this.formBuilder.group({
      visaType: [this.employee.visaStatus.visaType, Validators.required],
      visaStartDate: [this.employee.visaStatus.visaEndDate, Validators.required],
      visaEndDate: [this.employee.visaStatus.visaEndDate, Validators.required]
    });
    this.emergencyContactForm = this.formBuilder.group({
      emergencyContacts: this.formBuilder.array([
        []
      ])
    });
    this.emergencyContacts = this.emergencyContactForm.get("emergencyContacts") as FormArray;
    this.addExistingEmergencyContacts();
  }

  ngOnInit(): void {
    console.log(JSON.parse(localStorage.getItem('currentEmployee')));

    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  addExistingEmergencyContacts(){
    for (let i = 0; i < this.employee.contact.length - 1; i++){
      if (this.employee.contact[i].emergency){
        this.emergencyContacts.push(
          this.formBuilder.group({
            firstName: [this.employee.contact[i].firstName],
            lastName: [this.employee.contact[i].lastName],
            cellphone: [this.employee.contact[i].cellphone],
            email: [this.employee.contact[i].email],
            relationship: [this.employee.contact[i].relationship]
          })
        );
      }
    }
  }

  createEmergencyContact(): FormGroup{
    return this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      cellphone: [''],
      email: [''],
      relationship: [''],
      });
  }

  addEmergencyContact(){
    var contact: Contact = new Contact();
    contact.employee_id = this.employee.id;
    contact.emergency = true;
    contact.reference = false;
    contact.landlord = false;
    this.employee.contact.push(contact);
    console.log(this.employee.contact);
    this.emergencyContacts.push(this.createEmergencyContact());
  }

  // form toggles
  toggleNameForm(){
    if(this.showAddressForm){
      this.cancelAddressForm();
    } else if(this.showContactForm){
      this.cancelContactForm();
    } else if(this.showVisaStatusForm){
      this.cancelVisaStatusForm();
    } else if(this.showEmergencyContactForm){
      this.cancelEmergencyContactForm();
    } else {
      this.showNameFormBtn = !this.showNameFormBtn;
      this.showNameForm = !this.showNameForm;
    }
  }

  toggleContactForm(){
    if(this.showNameForm){
      this.cancelNameForm();
    } else if(this.showAddressForm){
      this.cancelAddressForm();
    } else if(this.showVisaStatusForm){
      this.cancelVisaStatusForm();
    } else if(this.showEmergencyContactForm){
      this.cancelEmergencyContactForm();
    } else {
      this.showContactFormBtn = !this.showContactFormBtn;
      this.showContactForm = !this.showContactForm;}
  }

  toggleAddressForm(){
    if(this.showNameForm){
      this.cancelNameForm();
    } else if(this.showContactForm){
      this.cancelContactForm();
    } else if(this.showVisaStatusForm){
      this.cancelVisaStatusForm();
    } else if(this.showEmergencyContactForm){
      this.cancelEmergencyContactForm();
    } else {
      this.showAddressFormBtn = !this.showAddressFormBtn;
      this.showAddressForm = !this.showAddressForm;
    }
  }

  toggleVisaStatusForm(){
    if(this.showNameForm){
      this.cancelNameForm();
    } else if (this.showAddressForm){
      this.cancelAddressForm();
    } else if (this.showContactForm){
      this.cancelContactForm();
    } else if (this.showEmergencyContactForm){
      this.cancelEmergencyContactForm();
    } else {
      this.showVisaStatusFormBtn = !this.showVisaStatusFormBtn;
      this.showVisaStatusForm = !this.showVisaStatusForm;
    }
  }

  toggleEmergencyContactForm(){
    if(this.showNameForm){
      this.cancelNameForm();
    } else if (this.showAddressForm){
      this.cancelAddressForm();
    } else if (this.showContactForm){
      this.cancelContactForm();
    } else if (this.showVisaStatusForm){
      this.cancelVisaStatusForm();
    } else {
      this.showEmergencyContactFormBtn = !this.showEmergencyContactFormBtn;
      this.showEmergencyContactForm = !this.showEmergencyContactForm;
    }
  }
  // submit forms
  submitNameForm(){
    console.log("Name form submitted.");
    localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
    this.updateEmployee(this.employee);
    this.toggleNameForm();
  }

  submitAddressForm(){
    console.log("Address form submitted.");
    localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
    this.updateAddress(this.employee.address);
    this.toggleAddressForm();
  }

  submitContactForm(){
    console.log("Contact form submitted.");
    localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
    this.updateEmployee(this.employee);
    this.toggleContactForm();
  }

  submitVisaStatusForm(){
    console.log("Visa Status form submitted.");
    localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
    this.updateVisaStatus(this.employee.visaStatus);
    this.toggleVisaStatusForm();
  }

  submitEmergencyContactForm(){
    console.log("Emergency Contact form submitted.");
    localStorage.setItem('currentEmployee', JSON.stringify(this.employee));
    this.updateEmergencyContacts(this.employee.contact);
    this.toggleEmergencyContactForm();
  }

  // cancel forms
  cancelNameForm(){
    if(confirm("Are you sure you want to discard changes in Name?")){
      this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
      this.toggleNameForm();
    }
  }

  cancelAddressForm(){
    if(confirm("Are you sure you want to discard changes in Address?")){
      this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
      this.toggleAddressForm();
    }
  }

  cancelContactForm(){
    if(confirm("Are you sure you want to discard changes in Contact Information?")){
      this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
      this.toggleContactForm();
    }
  }

  cancelVisaStatusForm(){
    console.log("In cancel Visa Form");
    if(confirm("Are you sure you want to discard changes in Work Authorization?")){
      this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
      this.toggleVisaStatusForm();
    }
  }

  cancelEmergencyContactForm(){
    console.log("In cancel Emergency Contact form");
    if(confirm("Are you sure you want to discard changes in Emergency Contact(s)?")){
      this.employee = JSON.parse(localStorage.getItem('currentEmployee'));
      this.toggleEmergencyContactForm();
    }
  }

  // update forms
  updateEmployee(employee: Employee){
    this.employeeService.updateEmployee(this.employee);
  }

  updateEmergencyContacts(contact: Contact[]){
    this.contactService.updateContact(this.employee.contact);
  }

  updateAddress(address: Address){
    this.addressService.updateAddress(this.employee.address);
  }

  updateVisaStatus(visaStatus: VisaStatus){
    this.visaStatusService.updateVisaStatus(this.employee.visaStatus);
  }

  calculateAge(dobStr: string): number{
    let birthday = new Date(dobStr);
    var ageDifMs = Date.now() - birthday.getTime();
    var ageDate = new Date(ageDifMs);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
  }
}
