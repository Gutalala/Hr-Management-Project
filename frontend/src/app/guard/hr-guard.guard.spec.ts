import { TestBed } from '@angular/core/testing';

import { HrGuardGuard } from './hr-guard.guard';

describe('HrGuardGuard', () => {
  let guard: HrGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(HrGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
