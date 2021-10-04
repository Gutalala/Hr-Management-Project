import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Employee } from 'src/app/models/Employee/employee.model';
import { OnboardingApiService } from 'src/app/service/onboarding-api/onboarding-api.service';
import { FormControl, Validators, FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { FileUploadService } from 'src/app/service/fileUploadService/file-upload.service';
import { UserService } from 'src/app/service/userService/user-service.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-onboarding',
  templateUrl: './onboarding.component.html',
  styleUrls: ['./onboarding.component.css']
})

export class OnboardingComponent implements OnInit {

  employee = new Employee();

  profileForm: FormGroup;
  emergency: FormArray;

  avatar: FileList | undefined;
  driverLicenseDocument: FileList | undefined;
  workDocument: FileList | undefined;
  workAuthControl = new FormControl('', Validators.required);
  documentCheck: boolean;

  workAuth = ['H1-B', 'L2', 'F1(CPT/OPT)', 'H4', 'Other'];

  constructor(private router: Router, private onboardingService: OnboardingApiService, private formBuilder: FormBuilder, private fileService: FileUploadService, private userService: UserService) { 
    this.profileForm = this.formBuilder.group({
      reference: this.formBuilder.group({
        firstName: [''],
        lastName: [''],
        middleName: [''],
        cellphone: [''],
        address: [''],
        email: [''],
        relationship: [''],
        reference: true,
      }),
      emergency: this.formBuilder.array([
        this.createEmergency()
      ])
    });
    this.emergency = this.profileForm.get("emergency") as FormArray;
    this.overrideToJSONDate();
    this.employee.email = this.userService.email;
    this.documentCheck = true;
  }

  overrideToJSONDate() {
    Date.prototype.toJSON = function () {
      return new Date(this).toISOString().split('T')[0];
    }
  }

  createEmergency(): FormGroup{
    return this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      middleName: [''],
      cellphone: ['', Validators.required],
      email: ['', Validators.required],
      relationship: ['', Validators.required],
      emergency: true,
      });
  }

  addEmergency(){
    this.emergency.push(this.createEmergency());
  }

  otherVisaCheck(){
    if (this.employee.visaStatus.visaType == 'Other'){
      this.employee.visaStatus.visaType = '';
      return true;
    }
    else (this.employee.visaStatus.visaType == 'H1-B' || 'L2' || 'F1(CPT/OPT)' || 'H4')
      return false;
  }

  setGreenCard(value: boolean){
    if (value == true)
      this.employee.visaStatus.visaType = 'Green Card';
    else
      this.employee.visaStatus.visaType = '';
  }

  setCitizen(value: boolean){
    if (value == true)
      this.employee.visaStatus.visaType = 'Citizen';
    else
      this.employee.visaStatus.visaType = '';
  }


  ngOnInit(): void {
  }

  activeVisaCheck(){
    if (new Date(this.employee.visaStatus.visaEndDate) > new Date()){
      this.employee.visaStatus.active = true;
    }
    else
      this.employee.visaStatus.active = false;
  }


  postOnboardingData(){
    this.activeVisaCheck();

    this.employee.user_id = this.userService.user_id;
    this.employee.contact = this.profileForm.get("emergency")?.value;
    this.employee.contact.push(this.profileForm.get('reference')?.value);
    this.onboardingService.postOnboardingData(this.employee)
          .subscribe(data => {console.log(this.employee)});
  }

  upload(){
    this.fileService.uploadAvatar(this.avatar[0], "casper");
    this.fileService.uploadDocument(this.driverLicenseDocument[0]);
    this.fileService.uploadDocument(this.workDocument[0]);
  }

  selectAvatar(event: any) {
    this.avatar = event.target.files;
  }
  selectDriverLicense(event: any) {
    this.driverLicenseDocument = event.target.files;
  }
  selectWorkDocument(event: any) {
    this.workDocument = event.target.files;
  }

  approvalRouting(){
    this.router.navigate(['employee/awaitingApproval']);
  }
}
