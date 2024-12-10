import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VendorNavBarComponent } from "../NavBar/vendor-nav-bar/vendor-nav-bar.component";
import { CustomerNavBarComponent } from "../NavBar/customer-nav-bar/customer-nav-bar.component";
import { OrganizerNavBarComponent } from '../NavBar/organizer-nav-bar/organizer-nav-bar.component';
import { User } from '../app-classes/User/user';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [OrganizerNavBarComponent, VendorNavBarComponent, CustomerNavBarComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {

  constructor(private activeRoute:ActivatedRoute) {}

  logedInUser: any = new User();

  ngOnInit(): void {
    this.logedInUser = history.state;
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
    this.logedInUser = history.state;
  }
}
