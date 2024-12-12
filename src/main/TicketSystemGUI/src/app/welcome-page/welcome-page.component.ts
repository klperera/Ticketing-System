import { Component, OnInit } from '@angular/core';
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

  user: User = new User();
  logedInUser: User = new User();

  constructor(private router: Router){}

  signUp(usertype: string){
    this.user.usertype = usertype;
    this.router.navigate([`${this.user.usertype}/signUp`]);
  }
}
