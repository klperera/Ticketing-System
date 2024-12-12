import { Component, OnInit } from '@angular/core';
import { CustomerNavBarComponent } from '../NavBar/customer-nav-bar/customer-nav-bar.component';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../Service/user-service.service';
import { User } from '../app-classes/User/user';

@Component({
  selector: 'app-all-event-customer',
  standalone: true,
  imports: [CustomerNavBarComponent, CommonModule],
  templateUrl: './all-event-customer.component.html',
  styleUrl: './all-event-customer.component.css'
})
export class AllEventCustomerComponent implements OnInit {

  logedInUser: any = {};
  details: any = {};
  user: any = {};
  ticketPurchase = {
    event: {},
    logedInUser: {},
    vendorID: ''
  }

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService, private router: Router) { }

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    console.log(this.logedInUser);
    this.user = this.logedInUser.usercredentials;
    this.user.usertype = this.logedInUser.usertype;
    console.log(this.user.usertype); 
    this.userService.user_method(this.user, 'allevents').subscribe(
      (response) => {
        this.details = response;
        console.log(this.details);
        console.log(`${this.logedInUser.usertype}`+" - Data passed.");
        if (this.details.message === "All events have been found.") {
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
    this.ticketPurchase.vendorID = event.vendorID;
    console.log(this.ticketPurchase);
    this.router.navigateByUrl(`${this.logedInUser.usertype}/addToTicketPool`, {state: this.ticketPurchase});
  }

}
