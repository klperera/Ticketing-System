import { Component, OnInit } from '@angular/core';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { User } from '../app-classes/User/user';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';
import { CommonModule } from '@angular/common';
import { CustomerNavBarComponent } from '../NavBar/customer-nav-bar/customer-nav-bar.component';

@Component({
  selector: 'app-all-events',
  standalone: true,
  imports: [CommonModule,VendorNavBarComponent, CustomerNavBarComponent],
  templateUrl: './all-events-vendor.component.html',
  styleUrl: './all-events-vendor.component.css'
})
export class AllEventsComponent implements OnInit {

  logedInUser: any = {};
  user: User = new User();
  details: any = {};
  ticketPurchase = {
    event: {},
    logedInUser: {}
  }

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) {}

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
          // alert(this.details.message);
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
  buyTicket(event: any) {
    this.ticketPurchase.event = event;
    this.ticketPurchase.logedInUser = this.logedInUser;
    console.log(this.ticketPurchase);
    this.router.navigateByUrl(`${this.logedInUser.usertype}/purchaseTickets`, {state: this.ticketPurchase});
  }
  addToTicketPool(event: any){
    this.ticketPurchase.event = event;
    this.ticketPurchase.logedInUser = this.logedInUser;
    console.log(this.ticketPurchase);
    this.router.navigateByUrl(`${this.logedInUser.usertype}/addToTicketPool`, {state: this.ticketPurchase});
  }
}
