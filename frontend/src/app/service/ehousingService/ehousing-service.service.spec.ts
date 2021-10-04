import { TestBed } from '@angular/core/testing';

import { EhousingService } from './ehousing-service.service';

describe('EhousingService', () => {
  let service: EhousingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EhousingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
