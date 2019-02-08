import { TestBed } from '@angular/core/testing';

import { Allservice2Service } from './allservice2.service';

describe('Allservice2Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Allservice2Service = TestBed.get(Allservice2Service);
    expect(service).toBeTruthy();
  });
});
