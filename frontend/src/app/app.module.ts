import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OnboardingComponent } from './component/onboarding/onboarding.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { NgxMaskModule, IConfig } from 'ngx-mask';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { EmployeeHomePageComponent } from './component/employeeComponent/employee-home-page/employee-home-page.component';
import { EmployeeNavibarComponent } from './component/employeeComponent/employee-navibar/employee-navibar.component';
import { PersonalInformationComponent } from './component/employeeComponent/personal-information/personal-information.component';
import { EmployeeHrNavigatorComponent } from './component/general/employee-hr-navigator/employee-hr-navigator.component';
import { HrHomePageComponent } from './component/hrComponent/hr-home-page/hr-home-page.component';
import { HrNavibarComponent } from './component/hrComponent/hr-navibar/hr-navibar.component';

import { DocumentationPageComponent } from './component/documentation-page/documentation-page.component';
import { AccountCreationComponent } from './component/account-creation/account-creation.component';

import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { ViewProfileComponent } from './component/hrComponent/view-profile/view-profile.component';
import { CreateReportComponent } from './component/create-report/create-report.component';
import { ViewReportComponent } from './component/view-report/view-report.component';
import { EhousingComponent } from './component/ehousing/ehousing.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HrhousingComponent } from './component/hrhousing/hrhousing.component';
import { AddFacilityComponent } from './component/add-facility/add-facility.component';
import { ViewFacilityComponent } from './component/view-facility/view-facility.component';
import { DeleteFacilityComponent } from './component/delete-facility/delete-facility.component';
import { HireComponent } from './hrcomponent/hire/hire.component';
import { ApplicationreviewComponent } from './hrcomponent/applicationreview/applicationreview.component';
import { DocumentsreviewComponent } from './hrcomponent/hire/documentsreview/documentsreview.component';
import { VisaemployeeComponent } from './hrcomponent/visaemployee/visaemployee.component';
import { VisahrComponent } from './hrcomponent/visahr/visahr.component';
import { RegisterComponent } from './component/register/register.component';
import { GeneratetokenComponent } from './hrcomponent/hire/generatetoken/generatetoken.component';
import { HrcomponenttrackingtableComponent } from './hrcomponent/hrcomponenttrackingtable/hrcomponenttrackingtable.component';
import { VisaemployeedocumentsComponent } from './hrcomponent/visaemployee/visaemployeedocuments/visaemployeedocuments.component';
import { LoginComponent } from './component/login/login/login.component';
import { HrcomponentComponent } from './hrcomponent/hrcomponent.component';
import { GuardGuard } from './guard/guard.guard';
import { HrGuardGuard } from './guard/hr-guard.guard';
import { DetailsUploadComponent } from './component/details-upload/details-upload.component';
import { AwaitingApprovalComponent } from './component/awaiting-approval/awaiting-approval.component';



@NgModule({
  declarations: [
    AppComponent,
    OnboardingComponent,
    EmployeeHomePageComponent,
    EmployeeNavibarComponent,
    PersonalInformationComponent,
    EmployeeHrNavigatorComponent,
    HrHomePageComponent,
    HrNavibarComponent,
    DocumentationPageComponent,
    AccountCreationComponent,
    ViewProfileComponent,
    CreateReportComponent,
    ViewReportComponent,
    EhousingComponent,
    HrhousingComponent,
    AddFacilityComponent,
    ViewFacilityComponent,
    DeleteFacilityComponent,
    HireComponent,
    ApplicationreviewComponent,
    DocumentsreviewComponent,
    VisaemployeedocumentsComponent,
    VisaemployeeComponent,
    VisahrComponent,
    RegisterComponent,
    GeneratetokenComponent,
    HrcomponenttrackingtableComponent,
    LoginComponent,
    HrcomponentComponent,
    DetailsUploadComponent,
    AwaitingApprovalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, 
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatListModule,
    MatTableModule,
    MatButtonModule,
    MatPaginatorModule,
    NgxMaskModule.forRoot(),
    MatSnackBarModule,
    PdfViewerModule
  ],
  
  providers: [GuardGuard, HrGuardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
