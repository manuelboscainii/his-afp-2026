import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RoutingError } from './routing-error';

describe('RoutingError', () => {
  let component: RoutingError;
  let fixture: ComponentFixture<RoutingError>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RoutingError],
    }).compileComponents();

    fixture = TestBed.createComponent(RoutingError);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
