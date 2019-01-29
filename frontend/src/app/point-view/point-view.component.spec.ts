import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PointViewComponent } from './point-view.component';

describe('PointViewComponent', () => {
  let component: PointViewComponent;
  let fixture: ComponentFixture<PointViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PointViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PointViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
