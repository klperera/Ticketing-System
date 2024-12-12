import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-add-to-ticket-pool',
  standalone: true,
  imports: [VendorNavBarComponent, FormsModule],
  templateUrl: './add-to-ticket-pool.component.html',
  styleUrl: './add-to-ticket-pool.component.css'
})
export class AddToTicketPoolComponent implements OnInit {

  logedInUser: any = {};
  isDropDownOpen = false;
  reciveDetails: any = {};
  allDetails: any = {};
  ticketDetails = {
    earlyBirdTicket :
    {
        numberOfTickets : "",
        discount : ""
    },
    generalTicket : 
    {
        numberOfTickets : "",
        discount : ""
    },
    lastMinuteTicket : 
    {
        numberOfTickets : "",
        discount : ""
    }
  };

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.reciveDetails = history.state;
    console.log(this.reciveDetails);
    this.logedInUser = this.reciveDetails.logedInUser;
  }
  toggleDropDown() {
    this.isDropDownOpen = !this.isDropDownOpen;  
  }
  addToTicketPool() {
    this.allDetails.ticketDetails = this.ticketDetails;
    this.allDetails.logedInUser = this.logedInUser;
    this.allDetails.event = this.reciveDetails.event;
    console.log(this.allDetails);
    this.userService.addToTicketPool(this.allDetails, 'addToTicketPool').subscribe(
      (response) => {
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        console.log(response);
        if (response.message === "All tickets have been added to the pool") {
          alert(response.message);
          console.log(response.object);
          this.router.navigateByUrl(`${this.logedInUser.usertype}/home`, {state: response.object});
        }else{
          alert(response.message);
        }
      },
      (error) =>{
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  }
}
