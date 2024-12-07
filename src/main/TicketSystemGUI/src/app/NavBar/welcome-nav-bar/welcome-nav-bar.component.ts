import { NgClass } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-welcome-nav-bar',
  standalone: true,
  imports: [NgClass],
  templateUrl: './welcome-nav-bar.component.html',
  styleUrl: './welcome-nav-bar.component.css'
})
export class WelcomeNavBarComponent {
  isDropDownOpen = false;

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }
}
