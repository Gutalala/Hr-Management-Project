import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeHrNavigatorComponent } from './employee-hr-navigator.component';

describe('EmployeeHrNavigatorComponent', () => {
  let component: EmployeeHrNavigatorComponent;
  let fixture: ComponentFixture<EmployeeHrNavigatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeHrNavigatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeHrNavigatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
