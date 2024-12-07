import { Component } from '@angular/core';
import { NavBarComponent } from '../NavBar/nav-bar/nav-bar.component';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { FormsModule } from '@angular/forms';
import { User } from '../app-classes/User/user';
import { UserService } from '../Service/user.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink, WelcomeNavBarComponent, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user: User = new User();

  constructor(private userService: UserService){

  }

  submit(){
    this.userService.passUserData(this.user).subscribe(
      (response) => {
        console.log("Data passed.");
      },
      (error) => {
        console.log("Error.");
      }
    );
  }
}
