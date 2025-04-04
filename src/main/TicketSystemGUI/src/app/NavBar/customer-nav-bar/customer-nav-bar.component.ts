import { NgClass } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { User } from '../../app-classes/User/user';

@Component({
  selector: 'app-customer-nav-bar',
  standalone: true,
  imports: [NgClass],
  templateUrl: './customer-nav-bar.component.html',
  styleUrl: './customer-nav-bar.component.css'
})
export class CustomerNavBarComponent implements OnInit {

  isDropDownOpen = false;
  @Input() logedInUser: User = new User();

  constructor(private router: Router, private activeRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
  }

  toggleDropDown() {
    this.isDropDownOpen = !this.isDropDownOpen;  
  }

  select_method(method: string){
    this.router.navigateByUrl(`${this.logedInUser.usertype}/${method}`, {state: this.logedInUser});
  }

}
