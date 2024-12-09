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
      this.userService.user_method(this.user,'register').subscribe(
        (response) => {
          console.log(`${this.user.usertype}`+" - Data passed.");
          if (response.message === "User registered successfully.") {
            alert(response.message);
            this.router.navigateByUrl(`${this.user.usertype}/signIn`,{state: response.object});
          }else{
            alert(response.message);
          }
        },
        (error) => {
          console.log(`${this.user.usertype}`+" - Error.");
        }
      );
    }
    else{
      console.log("all data required. " + `${this.user.usertype}`);
    }
  }

  signIn(){
    this.router.navigate([`${this.user.usertype}/signIn`]);
  }
}
