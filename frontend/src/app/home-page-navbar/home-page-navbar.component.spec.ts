import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageNavbarComponent } from './home-page-navbar.component';

describe('HomePageNavbarComponent', () => {
  let component: HomePageNavbarComponent;
  let fixture: ComponentFixture<HomePageNavbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomePageNavbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomePageNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
