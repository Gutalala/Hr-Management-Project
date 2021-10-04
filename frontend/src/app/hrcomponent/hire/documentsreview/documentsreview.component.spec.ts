import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentsreviewComponent } from './documentsreview.component';

describe('DocumentsreviewComponent', () => {
  let component: DocumentsreviewComponent;
  let fixture: ComponentFixture<DocumentsreviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentsreviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentsreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
