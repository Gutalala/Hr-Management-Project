import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisaemployeeComponent } from './visaemployee.component';

describe('VisaemployeeComponent', () => {
  let component: VisaemployeeComponent;
  let fixture: ComponentFixture<VisaemployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisaemployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisaemployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
