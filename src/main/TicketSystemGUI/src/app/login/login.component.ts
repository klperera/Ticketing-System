import { Component, OnInit } from '@angular/core';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { User } from '../app-classes/User/user';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [WelcomeNavBarComponent, RouterLink, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserServiceService, private activeRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.user.usertype = params.get('usertype') || 'user';
    });
  }

  login(){
    if (this.user.email !== "" && this.user.password !== "") {
      switch(this.user.usertype) {
        case "organizer": {
          this.userService.organizer_login(this.user).subscribe(
            (response) => {
              console.log("Organizer - Data passed.");
            },
            (error) => {
              console.log("Organizer - Error.");
            }
          );
          break;
        }
        case "vendor": {
          this.userService.vendor_login(this.user).subscribe(
            (response) => {
              console.log("vendor - Data passed.");
            },
            (error) => {
              console.log("vendor - Error.");
            }
          );
          break;
        }
        case "customer": {
          this.userService.customer_login(this.user).subscribe(
            (response) => {
              console.log("customer - Data passed.");
            },
            (error) => {
              console.log("customer - Error.");
            }
          );
          break;
        }
      }
    }
    else{
      console.log("all data required." + `${this.user.usertype}`);
    }
  }

}
