import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeDeliveryComponent } from './coffee-delivery.component';

describe('CoffeeDeliveryComponent', () => {
  let component: CoffeeDeliveryComponent;
  let fixture: ComponentFixture<CoffeeDeliveryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoffeeDeliveryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoffeeDeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
