import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowmanuComponent } from './showmanu.component';

describe('ShowmanuComponent', () => {
  let component: ShowmanuComponent;
  let fixture: ComponentFixture<ShowmanuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowmanuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowmanuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
