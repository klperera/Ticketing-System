import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-welcome-nav-bar',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './welcome-nav-bar.component.html',
  styleUrl: './welcome-nav-bar.component.css'
})
export class WelcomeNavBarComponent {
  isDropDownOpen = false;

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }
}
