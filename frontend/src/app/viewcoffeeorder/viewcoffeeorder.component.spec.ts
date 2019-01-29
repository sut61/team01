import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcoffeeorderComponent } from './viewcoffeeorder.component';

describe('ViewcoffeeorderComponent', () => {
  let component: ViewcoffeeorderComponent;
  let fixture: ComponentFixture<ViewcoffeeorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewcoffeeorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewcoffeeorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
