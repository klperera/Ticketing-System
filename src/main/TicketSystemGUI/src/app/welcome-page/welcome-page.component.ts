import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';

@Component({
  selector: 'app-welcome-page',
  standalone: true,
  imports: [WelcomeNavBarComponent],
  templateUrl: './welcome-page.component.html',
  styleUrl: './welcome-page.component.css'
})
export class WelcomePageComponent {

  private name: string = 'kalpa';

  constructor(private router: Router){

  }
  method(){
    this.router.navigate(['/register'])
  }
}
