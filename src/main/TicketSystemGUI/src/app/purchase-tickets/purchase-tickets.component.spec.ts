import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseTicketsComponent } from './purchase-tickets.component';

describe('PurchaseTicketsComponent', () => {
  let component: PurchaseTicketsComponent;
  let fixture: ComponentFixture<PurchaseTicketsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PurchaseTicketsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PurchaseTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
