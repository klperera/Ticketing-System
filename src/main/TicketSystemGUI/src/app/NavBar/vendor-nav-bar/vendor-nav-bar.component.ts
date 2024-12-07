import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-vendor-nav-bar',
  standalone: true,
  imports: [NgClass, RouterLink],
  templateUrl: './vendor-nav-bar.component.html',
  styleUrl: './vendor-nav-bar.component.css'
})
export class VendorNavBarComponent {
  isDropDownOpen = false;

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }
}
