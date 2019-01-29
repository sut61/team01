import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeorderComponent } from './coffeeorder.component';

describe('CoffeeorderComponent', () => {
  let component: CoffeeorderComponent;
  let fixture: ComponentFixture<CoffeeorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoffeeorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoffeeorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
