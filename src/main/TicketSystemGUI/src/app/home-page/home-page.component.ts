import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../app-classes/User/user';
import { OrganizerNavBarComponent } from "../NavBar/organizer-nav-bar/organizer-nav-bar.component";
import { VendorNavBarComponent } from "../NavBar/vendor-nav-bar/vendor-nav-bar.component";
import { CustomerNavBarComponent } from "../NavBar/customer-nav-bar/customer-nav-bar.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [OrganizerNavBarComponent, VendorNavBarComponent, CustomerNavBarComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {

  constructor(private activeRoute:ActivatedRoute, private router: Router) {}

  user: User = new User();

  ngOnInit(): void {
      this.activeRoute.paramMap.subscribe(params => {
        this.user.usertype = params.get('usertype') || 'user';
      }
    );
    this.user = history.state;
  }
}
