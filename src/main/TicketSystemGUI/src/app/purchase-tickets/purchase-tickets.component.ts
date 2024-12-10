import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { VendorNavBarComponent } from '../NavBar/vendor-nav-bar/vendor-nav-bar.component';
import { User } from '../app-classes/User/user';
import { ActivatedRoute } from '@angular/router';
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
  user: User = new User();
  details: any = {};

  constructor(private activeRoute: ActivatedRoute, private userService: UserServiceService) {}

  ngOnInit() {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
      this.user.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
    console.log(this.logedInUser);
  }
  purchaseTickets() {}

}
