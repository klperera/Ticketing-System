import { Component, OnInit } from '@angular/core';
import { WelcomeNavBarComponent } from '../NavBar/welcome-nav-bar/welcome-nav-bar.component';
import { ActivatedRoute, Router} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { User } from '../app-classes/User/user';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [WelcomeNavBarComponent, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserServiceService, private activeRoute: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.user.usertype = params.get('usertype') || 'user';
    });
  }

  login(){
    if (this.user.email !== "" && this.user.password !== "") {
      this.userService.user_method(this.user,'login').subscribe(
        (details) => {
          console.log(`${this.user.usertype}`+" - Data passed.");
          if (details.message === "Login successful.") {
            alert(details.message);
            this.router.navigateByUrl(`${this.user.usertype}/home`,{state: details.object});
          } else {
            alert(details.message);
          }
        },
        (error) => {
          console.log(`${this.user.usertype}`+" - Error.");
        }
      );
    }
    else{
      console.log("all data required." + `${this.user.usertype}`);
    }
  }
  signUp(){
    this.router.navigate([`${this.user.usertype}/signUp`]);
  }

}
