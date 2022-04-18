import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanstepComponent } from './loanstep.component';

describe('LoanstepComponent', () => {
  let component: LoanstepComponent;
  let fixture: ComponentFixture<LoanstepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanstepComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanstepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
