import { TestBed } from '@angular/core/testing';

import { GetLoanDataServiceService } from './get-loan-data-service.service';

describe('GetLoanDataServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetLoanDataServiceService = TestBed.get(GetLoanDataServiceService);
    expect(service).toBeTruthy();
  });
});
