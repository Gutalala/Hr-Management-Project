import { TestBed } from '@angular/core/testing';

import { OnboardingApiService } from './onboarding-api.service';

describe('OnboardingApiService', () => {
  let service: OnboardingApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OnboardingApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
