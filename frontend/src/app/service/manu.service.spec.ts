import { TestBed, inject } from '@angular/core/testing';

import { ManuService } from './manu.service';

describe('ManuService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ManuService]
    });
  });

  it('should be created', inject([ManuService], (service: ManuService) => {
    expect(service).toBeTruthy();
  }));
});
