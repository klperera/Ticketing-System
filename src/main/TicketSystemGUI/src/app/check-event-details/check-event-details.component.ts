import { Component, OnInit } from '@angular/core';
import { User } from '../app-classes/User/user';
import { ActivatedRoute, Router } from '@angular/router';
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-check-event-details',
  standalone: true,
  imports: [OrganizerNavBarComponent],
  templateUrl: './check-event-details.component.html',
  styleUrl: './check-event-details.component.css'
})
export class CheckEventDetailsComponent implements OnInit {

  logedInUser: any = {};
  user: User = new User();
  details: any = {};

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.user.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    this.user = this.logedInUser.userCredentials;
    this.user.usertype = this.logedInUser.usertype;
    // console.log(this.user);
    this.userService.user_method(this.user, 'checkevents').subscribe(
      (response) => {
        this.details = response;
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        if (this.details.message === "All events have been found.") {
          alert(this.details.message);
          console.log(this.details.object);
          //this.router.navigateByUrl(`${this.logedInUser.usertype}/home`, {state: this.logedInUser});
        }else{
          alert(this.details.message);
        }
      },
      (error) =>{
        alert(error.error.message);
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  } 
}
