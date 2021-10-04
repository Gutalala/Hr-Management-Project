import { TestBed } from '@angular/core/testing';

import { HrhousingService } from './hrhousing.service';

describe('HrhousingService', () => {
  let service: HrhousingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HrhousingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
