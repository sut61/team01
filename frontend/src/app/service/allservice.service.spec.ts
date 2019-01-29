import { TestBed } from '@angular/core/testing';

import { AllserviceService } from './allservice.service';

describe('AllserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllserviceService = TestBed.get(AllserviceService);
    expect(service).toBeTruthy();
  });
});
