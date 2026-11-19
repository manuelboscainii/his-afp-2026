import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RisLayout } from './ris-layout';

describe('RisLayout', () => {
  let component: RisLayout;
  let fixture: ComponentFixture<RisLayout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RisLayout],
    }).compileComponents();

    fixture = TestBed.createComponent(RisLayout);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
