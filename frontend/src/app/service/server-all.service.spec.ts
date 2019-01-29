import { TestBed, inject } from '@angular/core/testing';

import { ServerAllService } from './server-all.service';

describe('ServerAllService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServerAllService]
    });
  });

  it('should be created', inject([ServerAllService], (service: ServerAllService) => {
    expect(service).toBeTruthy();
  }));
});
