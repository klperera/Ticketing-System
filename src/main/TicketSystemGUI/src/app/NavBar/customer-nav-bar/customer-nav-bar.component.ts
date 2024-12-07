import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-customer-nav-bar',
  standalone: true,
  imports: [NgClass, RouterLink],
  templateUrl: './customer-nav-bar.component.html',
  styleUrl: './customer-nav-bar.component.css'
})
export class CustomerNavBarComponent {

  isDropDownOpen = false;

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }

}
