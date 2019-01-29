import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomestaffComponent } from './homestaff.component';

describe('HomestaffComponent', () => {
  let component: HomestaffComponent;
  let fixture: ComponentFixture<HomestaffComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomestaffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomestaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
