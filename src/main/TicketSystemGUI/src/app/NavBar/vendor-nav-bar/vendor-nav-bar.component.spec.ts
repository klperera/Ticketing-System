import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorNavBarComponent } from './vendor-nav-bar.component';

describe('VendorNavBarComponent', () => {
  let component: VendorNavBarComponent;
  let fixture: ComponentFixture<VendorNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VendorNavBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VendorNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
