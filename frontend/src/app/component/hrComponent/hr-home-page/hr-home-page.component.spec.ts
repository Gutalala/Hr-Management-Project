import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HrHomePageComponent } from './hr-home-page.component';

describe('HrHomePageComponent', () => {
  let component: HrHomePageComponent;
  let fixture: ComponentFixture<HrHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HrHomePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HrHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
