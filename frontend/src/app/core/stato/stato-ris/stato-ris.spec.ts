import { TestBed } from '@angular/core/testing';
import { StatoRis } from './stato-ris';

describe('StatoRis', () => {
  let service: StatoRis;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatoRis);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
