import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EhousingComponent } from './ehousing.component';

describe('EhousingComponent', () => {
  let component: EhousingComponent;
  let fixture: ComponentFixture<EhousingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EhousingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EhousingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
