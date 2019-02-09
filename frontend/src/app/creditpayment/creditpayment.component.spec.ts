import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditpaymentComponent } from './creditpayment.component';

describe('CreditpaymentComponent', () => {
  let component: CreditpaymentComponent;
  let fixture: ComponentFixture<CreditpaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditpaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditpaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
