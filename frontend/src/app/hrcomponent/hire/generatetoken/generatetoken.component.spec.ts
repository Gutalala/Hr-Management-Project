import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneratetokenComponent } from './generatetoken.component';

describe('GeneratetokenComponent', () => {
  let component: GeneratetokenComponent;
  let fixture: ComponentFixture<GeneratetokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GeneratetokenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneratetokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
