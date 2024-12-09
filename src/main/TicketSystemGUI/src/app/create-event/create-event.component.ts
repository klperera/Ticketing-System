import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { User } from '../app-classes/User/user';
import { Event } from '../app-classes/Event/event';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [FormsModule, OrganizerNavBarComponent],
  templateUrl: './create-event.component.html',
  styleUrl: './create-event.component.css'
})
export class CreateEventComponent implements OnInit {

  logedInUser: User = new User();
  event: Event = new Event();

  constructor(private activeRoute: ActivatedRoute, private route: Router, private userService: UserServiceService) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state; 
  }
  createEvent() {
    this.event.organizer = this.logedInUser;
    console.log(this.event);  
    this.userService.event_method(this.event, 'newevent').subscribe(
      (details) => {
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        if (details.message === "Event has been created.") {
          alert(details.message);
          this.route.navigateByUrl(`${this.logedInUser.usertype}/home`,{state: details.object});
        }else{
          alert(details.message);
        }
      },
      (error) =>{
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  }
}
