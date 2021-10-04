import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeNavibarComponent } from './employee-navibar.component';

describe('EmployeeNavibarComponent', () => {
  let component: EmployeeNavibarComponent;
  let fixture: ComponentFixture<EmployeeNavibarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeNavibarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeNavibarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
