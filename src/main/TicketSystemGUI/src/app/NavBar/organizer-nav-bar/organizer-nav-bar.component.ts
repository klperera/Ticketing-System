import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-organizer-nav-bar',
  standalone: true,
  imports: [NgClass, RouterLink],
  templateUrl: './organizer-nav-bar.component.html',
  styleUrl: './organizer-nav-bar.component.css'
})
export class OrganizerNavBarComponent {
  isDropDownOpen = false;

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }
}
