import { ComponentFixture, TestBed } from '@angular/core/testing';
import { StatoSio } from './stato-sio';

describe('StatoSio', () => {
  let component: StatoSio;
  let fixture: ComponentFixture<StatoSio>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatoSio],
    }).compileComponents();

    fixture = TestBed.createComponent(StatoSio);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
