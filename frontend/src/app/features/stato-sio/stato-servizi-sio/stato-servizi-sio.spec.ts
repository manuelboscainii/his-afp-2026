import { TestBed } from '@angular/core/testing';
import { StatoSio } from './stato-servizi-sio';

describe('StatoSio', () => {
  let service: StatoSio;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatoSio);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
