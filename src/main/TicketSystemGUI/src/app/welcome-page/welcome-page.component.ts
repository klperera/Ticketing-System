import { Component } from '@angular/core';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { Router } from '@angular/router';
import { User } from '../app-classes/User/user';

@Component({
  selector: 'app-welcome-page',
  standalone: true,
  imports: [WelcomeNavBarComponent],
  templateUrl: './welcome-page.component.html',
  styleUrl: './welcome-page.component.css'
})
export class WelcomePageComponent {

  constructor(private router: Router){}

  signUp(usertype: string){
    this.router.navigate([`${usertype}/signUp`]);
  }
}
