import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HrNavibarComponent } from './hr-navibar.component';

describe('HrNavibarComponent', () => {
  let component: HrNavibarComponent;
  let fixture: ComponentFixture<HrNavibarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HrNavibarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HrNavibarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
