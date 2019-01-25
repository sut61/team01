import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowpayComponent } from './showpay.component';

describe('ShowpayComponent', () => {
  let component: ShowpayComponent;
  let fixture: ComponentFixture<ShowpayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowpayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowpayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
