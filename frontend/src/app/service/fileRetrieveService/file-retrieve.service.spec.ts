import { TestBed } from '@angular/core/testing';

import { FileRetrieveService } from './file-retrieve.service';

describe('FileRetrieveService', () => {
  let service: FileRetrieveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FileRetrieveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
