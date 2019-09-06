import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAcceptedLoansComponent } from './view-accepted-loans.component';

describe('ViewAcceptedLoansComponent', () => {
  let component: ViewAcceptedLoansComponent;
  let fixture: ComponentFixture<ViewAcceptedLoansComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAcceptedLoansComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAcceptedLoansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
