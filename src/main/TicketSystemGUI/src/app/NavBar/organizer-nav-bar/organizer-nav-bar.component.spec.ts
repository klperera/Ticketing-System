import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganizerNavBarComponent } from './organizer-nav-bar.component';

describe('OrganizerNavBarComponent', () => {
  let component: OrganizerNavBarComponent;
  let fixture: ComponentFixture<OrganizerNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrganizerNavBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrganizerNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
