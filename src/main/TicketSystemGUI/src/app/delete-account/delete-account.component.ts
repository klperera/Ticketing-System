import { Component, OnInit } from '@angular/core';
import { User } from '../app-classes/User/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';
import { FormsModule } from '@angular/forms';
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { CustomerNavBarComponent } from '../NavBar/customer-nav-bar/customer-nav-bar.component';

@Component({
  selector: 'app-delete-account',
  standalone: true,
  imports: [FormsModule, OrganizerNavBarComponent, VendorNavBarComponent, CustomerNavBarComponent],
  templateUrl: './delete-account.component.html',
  styleUrl: './delete-account.component.css'
})
export class DeleteAccountComponent implements OnInit {

  user: User = new User();
  logedInUser: User = new User();

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
      this.user.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    console.log(this.logedInUser);
  }
  deleteAccount() {
    console.log(this.user);
    if (this.user.email !== "" && this.user.password !== "") {
      this.userService.user_method(this.user, 'deleteaccount').subscribe(
        (details) => {
          console.log(`${this.logedInUser.usertype}`+" - Data passed.");
          if (details.message === "Account deleted successfully.") {
            alert(details.message);
            this.router.navigateByUrl(`/welcomePage`);
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
