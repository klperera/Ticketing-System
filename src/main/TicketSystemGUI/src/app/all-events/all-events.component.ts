import { Component, OnInit } from '@angular/core';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { User } from '../app-classes/User/user';
import { ActivatedRoute } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-all-events',
  standalone: true,
  imports: [VendorNavBarComponent],
  templateUrl: './all-events.component.html',
  styleUrl: './all-events.component.css'
})
export class AllEventsComponent implements OnInit {

  logedInUser: any = new User();
  user: User = new User();
  details: any = {};

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    this.user = this.logedInUser.userCredentials;
    this.user.usertype = this.logedInUser.usertype;
    console.log(this.user); 
    this.userService.user_method(this.user, 'allevents').subscribe(
      (response) => {
        this.details = response;
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        if (this.details.message === "All events have been found") {
          alert(this.details.message);
          console.log(this.details.object);
          //this.router.navigateByUrl(`${this.logedInUser.usertype}/home`, {state: this.logedInUser});
        }else{
          alert(this.details.message);
        }
      },
      (error) =>{
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  }

}
