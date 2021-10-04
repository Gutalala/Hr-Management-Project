import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisaemployeedocumentsComponent } from './visaemployeedocuments.component';

describe('VisaemployeedocumentsComponent', () => {
  let component: VisaemployeedocumentsComponent;
  let fixture: ComponentFixture<VisaemployeedocumentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VisaemployeedocumentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VisaemployeedocumentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
