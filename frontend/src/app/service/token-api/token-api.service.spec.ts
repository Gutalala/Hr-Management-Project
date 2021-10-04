import { TestBed } from '@angular/core/testing';

import { TokenApiService } from './token-api.service';

describe('TokenApiService', () => {
  let service: TokenApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
