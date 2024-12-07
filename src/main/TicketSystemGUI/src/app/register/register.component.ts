import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { FormsModule } from '@angular/forms';
import { User } from '../app-classes/User/user';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [WelcomeNavBarComponent, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserServiceService, private activeRoute: ActivatedRoute, private router: Router){}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.user.usertype = params.get('usertype') || 'user';
    });
  }

  register() {
    if (this.user.email !== "" && this.user.username !== "" && this.user.password !== "") {
      switch(this.user.usertype) {
        case "organizer": {
          this.userService.organizer_register(this.user).subscribe(
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
          this.userService.vendor_register(this.user).subscribe(
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
          this.userService.customer_register(this.user).subscribe(
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

  select(){
    this.router.navigate([`${this.user.usertype}/signIn`]);
  }
}
