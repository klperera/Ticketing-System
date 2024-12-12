import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { User } from '../app-classes/User/user';
import { Event } from '../app-classes/Event/event';
import { UserServiceService } from '../Service/user-service.service';
import { ActivatedRoute, Router } from '@angular/router';

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

  constructor(private activeRoute: ActivatedRoute, private router: Router, private userService: UserServiceService) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state; 
  }
  createEvent() {
    if (this.event.eventName !== "" || this.event.eventLocation !== "" || this.event.eventPrice !== "") {
      this.event.organizer = this.logedInUser;  
    this.userService.event_method(this.event, 'newevent').subscribe(
      (details) => {
        console.log(details);
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        if (details.message === "Event has been created.") {
          alert(details.message);
        }else{
          alert(details.message);
        }
      },
      (error) =>{
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
    }else{
      console.log("all data required. " + `${this.logedInUser.usertype}`);
    }
  }
}
