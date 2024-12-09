import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckEventDetailsComponent } from './check-event-details.component';

describe('CheckEventDetailsComponent', () => {
  let component: CheckEventDetailsComponent;
  let fixture: ComponentFixture<CheckEventDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckEventDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckEventDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
