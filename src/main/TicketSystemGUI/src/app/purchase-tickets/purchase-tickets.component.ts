import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { User } from '../app-classes/User/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';

@Component({
  selector: 'app-purchase-tickets',
  standalone: true,
  imports: [FormsModule, VendorNavBarComponent],
  templateUrl: './purchase-tickets.component.html',
  styleUrl: './purchase-tickets.component.css'
})
export class PurchaseTicketsComponent implements OnInit {

  logedInUser: any = new User();
  ticketPurchase: any = {};
  numOfTickets: number = 0;
  sendDetails: any = {};

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.ticketPurchase = history.state;
    this.logedInUser = this.ticketPurchase.logedInUser;
    console.log(this.ticketPurchase);
  }
  purchaseTickets() {
    this.sendDetails.vendorID = this.ticketPurchase.logedInUser.vendorId;
    this.sendDetails.eventID = this.ticketPurchase.event.eventID;
    this.sendDetails.totalTickets = this.numOfTickets;
    this.sendDetails.logedInUser = this.logedInUser;
    console.log(this.sendDetails);

    this.userService.purchaseTickets_method( this.sendDetails, 'purchasetickets').subscribe(
      (response) => {
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        console.log(response);
        if (response.message === "Tickets purchase successfully") {
          console.log(response.message);
          alert(response.message);
          this.sendDetails.responseObject = response.object;
          console.log(this.sendDetails);
          this.router.navigateByUrl(`${this.logedInUser.usertype}/addToTicketPool`, {state: this.sendDetails});
        }else{
          alert(response.message);
          this.router.navigateByUrl(`${this.logedInUser.usertype}/home`, {state: this.sendDetails.logedInUser});
        }
      },
      (error) =>{
        alert(error.error.message);
        console.log(`${this.logedInUser.usertype}`+" - Error.");
      }
    );
  }

}
