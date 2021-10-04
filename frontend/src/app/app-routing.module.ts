import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AccountCreationComponent } from './component/account-creation/account-creation.component';
import { AwaitingApprovalComponent } from './component/awaiting-approval/awaiting-approval.component';
import { DocumentationPageComponent } from './component/documentation-page/documentation-page.component';
import { EhousingComponent } from './component/ehousing/ehousing.component';
import { EmployeeHomePageComponent } from './component/employeeComponent/employee-home-page/employee-home-page.component';
import { PersonalInformationComponent } from './component/employeeComponent/personal-information/personal-information.component';
import { HrHomePageComponent } from './component/hrComponent/hr-home-page/hr-home-page.component';
import { ViewProfileComponent } from './component/hrComponent/view-profile/view-profile.component';
import { HrhousingComponent } from './component/hrhousing/hrhousing.component';
import { LoginComponent } from './component/login/login/login.component';
import { OnboardingComponent } from './component/onboarding/onboarding.component';
import { RegisterComponent } from './component/register/register.component';
import { GuardGuard } from './guard/guard.guard';
import { HrGuardGuard } from './guard/hr-guard.guard';
import { ApplicationreviewComponent } from './hrcomponent/applicationreview/applicationreview.component';
import { HireComponent } from './hrcomponent/hire/hire.component';
import { HrcomponenttrackingtableComponent } from './hrcomponent/hrcomponenttrackingtable/hrcomponenttrackingtable.component';
import { VisaemployeeComponent } from './hrcomponent/visaemployee/visaemployee.component';
import { VisahrComponent } from './hrcomponent/visahr/visahr.component';

const routes: Routes = [
  {path: 'login' , component : LoginComponent},
  {path: 'CreateAccount/:token', component: AccountCreationComponent},
  {path: 'register' , component: RegisterComponent},
  {path: 'onboarding', component: OnboardingComponent},
  {path: 'employee', component: EmployeeHomePageComponent, canActivate: [GuardGuard]},
  {path: 'employee/homepage', component: EmployeeHomePageComponent, canActivate: [GuardGuard]},
  {path: 'employee/personalInformation', component: PersonalInformationComponent, canActivate: [GuardGuard]},
  {path: 'employee/housing', component: EhousingComponent, canActivate: [GuardGuard]},
  {path: 'employee/visaStatus' , component: VisaemployeeComponent, canActivate: [GuardGuard]},
  {path: 'employee/awaitingApproval' , component: AwaitingApprovalComponent},


  {path: 'hr', component: HrHomePageComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/homepage', component: HrcomponenttrackingtableComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/employeeProfile', component: ViewProfileComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/housing', component: HrhousingComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/hire' , component: HireComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/application/:empid' , component: ApplicationreviewComponent, canActivate: [HrGuardGuard]},
  {path: 'hr/visaStatus' , component: VisahrComponent, canActivate: [HrGuardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
