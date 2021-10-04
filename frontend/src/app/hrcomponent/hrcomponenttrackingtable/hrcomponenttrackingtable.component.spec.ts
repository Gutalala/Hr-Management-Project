import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HrcomponenttrackingtableComponent } from './hrcomponenttrackingtable.component';

describe('HrcomponenttrackingtableComponent', () => {
  let component: HrcomponenttrackingtableComponent;
  let fixture: ComponentFixture<HrcomponenttrackingtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HrcomponenttrackingtableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HrcomponenttrackingtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
