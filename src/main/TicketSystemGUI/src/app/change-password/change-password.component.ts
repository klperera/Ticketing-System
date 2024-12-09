import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../app-classes/User/user';
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { CustomerNavBarComponent } from '../NavBar/customer-nav-bar/customer-nav-bar.component';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-change-password',
  standalone: true,
  imports: [FormsModule, OrganizerNavBarComponent, VendorNavBarComponent, CustomerNavBarComponent],
  templateUrl: './change-password.component.html',
  styleUrl: './change-password.component.css'
})
export class ChangePasswordComponent implements OnInit {

 user: User = new User();
 logedInUser: any = new User();

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
      this.user.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    console.log(this.logedInUser);
  }

  savePassword() {
    console.log(this.user);
    if (this.user.email === this.logedInUser.userCredentials.email && this.user.password !== "") {
      this.userService.user_method(this.user, 'changepassword').subscribe(
        (details) => {
          console.log(`${this.logedInUser.usertype}`+" - Data passed.");
          if (details.message === "Password changed successfully.") {
            alert(details.message);
            this.router.navigateByUrl(`${this.logedInUser.usertype}/home`,{state: details.object});
          }else{
            alert(details.message);
          }
        },
        (error) =>{
          console.log(`${this.logedInUser.usertype}`+" - Error.");
        }
      );
    }
    else{
      console.log("all data required. " + `${this.logedInUser.usertype}`);
    }
  }
}
