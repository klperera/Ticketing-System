import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddToTicketPoolComponent } from './add-to-ticket-pool.component';

describe('AddToTicketPoolComponent', () => {
  let component: AddToTicketPoolComponent;
  let fixture: ComponentFixture<AddToTicketPoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddToTicketPoolComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddToTicketPoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
