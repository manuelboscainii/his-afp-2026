import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PathologiesDropdown } from './pathologies-dropdown';

describe('PathologiesDropdown', () => {
  let component: PathologiesDropdown;
  let fixture: ComponentFixture<PathologiesDropdown>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PathologiesDropdown],
    }).compileComponents();

    fixture = TestBed.createComponent(PathologiesDropdown);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
