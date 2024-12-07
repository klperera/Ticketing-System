import { Component } from '@angular/core';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [WelcomeNavBarComponent, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

}
