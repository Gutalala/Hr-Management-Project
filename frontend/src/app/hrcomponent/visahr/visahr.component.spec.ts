import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisahrComponent } from './visahr.component';

describe('VisahrComponent', () => {
  let component: VisahrComponent;
  let fixture: ComponentFixture<VisahrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisahrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisahrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
