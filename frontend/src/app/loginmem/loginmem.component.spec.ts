import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginmemComponent } from './loginmem.component';

describe('LoginmemComponent', () => {
  let component: LoginmemComponent;
  let fixture: ComponentFixture<LoginmemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginmemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginmemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
