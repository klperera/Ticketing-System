import { Component } from '@angular/core';
import { NavBarComponent } from '../NavBar/nav-bar/nav-bar.component';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink, WelcomeNavBarComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
}
