import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HrcomponentComponent } from './hrcomponent.component';

describe('HrcomponentComponent', () => {
  let component: HrcomponentComponent;
  let fixture: ComponentFixture<HrcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HrcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HrcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
