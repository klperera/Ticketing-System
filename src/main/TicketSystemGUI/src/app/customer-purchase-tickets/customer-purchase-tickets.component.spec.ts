import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerPurchaseTicketsComponent } from './customer-purchase-tickets.component';

describe('CustomerPurchaseTicketsComponent', () => {
  let component: CustomerPurchaseTicketsComponent;
  let fixture: ComponentFixture<CustomerPurchaseTicketsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerPurchaseTicketsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerPurchaseTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
