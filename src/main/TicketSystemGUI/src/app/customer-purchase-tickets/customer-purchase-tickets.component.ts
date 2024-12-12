import { Component, OnInit } from '@angular/core';
import { CustomerNavBarComponent } from '../NavBar/customer-nav-bar/customer-nav-bar.component';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';
import { User } from '../app-classes/User/user';
import { NgClass } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-customer-purchase-tickets',
  standalone: true,
  imports: [CustomerNavBarComponent, FormsModule],
  templateUrl: './customer-purchase-tickets.component.html',
  styleUrl: './customer-purchase-tickets.component.css'
})
export class CustomerPurchaseTicketsComponent implements OnInit {

  logedInUser: any = new User();
  ticketPurchase: any = {};
  numOfTickets: number = 0;
  sendDetails: any = {};
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

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.ticketPurchase = history.state;
    this.logedInUser = this.ticketPurchase.logedInUser;
    console.log(this.ticketPurchase); // event details, logedInUser
    
  }

  purchaseTickets() {
    this.sendDetails = this.ticketDetails;
    this.sendDetails.eventID = this.ticketPurchase.event.eventID;
    this.sendDetails.event = this.ticketPurchase.event;
    this.sendDetails.logedInUser = this.logedInUser;
    this.sendDetails.customerId = this.logedInUser.customerID;
    console.log(this.sendDetails);

    this.userService.purchaseTickets_method( this.sendDetails, 'buytickets').subscribe(
      (response) => {
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        console.log(response);
        if (response.message === "Tickets are purchased successfully") {
          console.log(response);
          alert(response.message);
          //this.sendDetails.responseObject = response.object;
          console.log(this.sendDetails);
        }else{
          alert(response.message);
        }
        this.router.navigateByUrl(`${this.logedInUser.usertype}/home`, {state: this.sendDetails.logedInUser});

      },
      (error) =>{
        alert(error.error.message);
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  }

}
