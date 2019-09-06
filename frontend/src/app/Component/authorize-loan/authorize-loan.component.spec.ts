import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizeLoanComponent } from './authorize-loan.component';

describe('AuthorizeLoanComponent', () => {
  let component: AuthorizeLoanComponent;
  let fixture: ComponentFixture<AuthorizeLoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizeLoanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizeLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
