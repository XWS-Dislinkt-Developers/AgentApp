import { TestBed } from '@angular/core/testing';

import { ImpresionsService } from './impresions.service';

describe('ImpresionsService', () => {
  let service: ImpresionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImpresionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
