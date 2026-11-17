import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Accettazione } from './accettazione';

describe('Accettazione', () => {
  let component: Accettazione;
  let fixture: ComponentFixture<Accettazione>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Accettazione],
    }).compileComponents();

    fixture = TestBed.createComponent(Accettazione);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
