import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogShoppingCarComponent } from './dialog-shopping-car.component';

describe('DialogShoppingCarComponent', () => {
  let component: DialogShoppingCarComponent;
  let fixture: ComponentFixture<DialogShoppingCarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogShoppingCarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogShoppingCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
