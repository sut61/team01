import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelMemberComponent } from './cancel-member.component';

describe('CancelMemberComponent', () => {
  let component: CancelMemberComponent;
  let fixture: ComponentFixture<CancelMemberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelMemberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelMemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
