import { TestBed } from '@angular/core/testing';

import { ClientehttpService } from './clientehttp.service';

describe('ClientehttpService', () => {
  let service: ClientehttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientehttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
