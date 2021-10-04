import { TestBed } from '@angular/core/testing';

import { PersonalDocumentService } from './personal-document.service';

describe('PersonalDocumentService', () => {
  let service: PersonalDocumentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonalDocumentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
