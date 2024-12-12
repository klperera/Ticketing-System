import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEventCustomerComponent } from './all-event-customer.component';

describe('AllEventCustomerComponent', () => {
  let component: AllEventCustomerComponent;
  let fixture: ComponentFixture<AllEventCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllEventCustomerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllEventCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
