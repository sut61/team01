import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomememComponent } from './homemem.component';

describe('HomememComponent', () => {
  let component: HomememComponent;
  let fixture: ComponentFixture<HomememComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomememComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomememComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
