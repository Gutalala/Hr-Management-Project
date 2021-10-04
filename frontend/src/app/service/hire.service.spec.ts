import { TestBed } from '@angular/core/testing';

import { HireService } from './hire.service';

describe('HireService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HireService = TestBed.get(HireService);
    expect(service).toBeTruthy();
  });
});
