import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogSendCoffeeComponent } from './dialog-send-coffee.component';

describe('DialogSendCoffeeComponent', () => {
  let component: DialogSendCoffeeComponent;
  let fixture: ComponentFixture<DialogSendCoffeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogSendCoffeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogSendCoffeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
