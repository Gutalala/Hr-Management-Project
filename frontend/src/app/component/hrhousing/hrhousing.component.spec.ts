import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrhousingComponent } from './hrhousing.component';

describe('HrhousingComponent', () => {
  let component: HrhousingComponent;
  let fixture: ComponentFixture<HrhousingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HrhousingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HrhousingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
