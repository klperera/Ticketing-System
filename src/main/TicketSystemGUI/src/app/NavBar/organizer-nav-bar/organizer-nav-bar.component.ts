import { NgClass } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../app-classes/User/user';

@Component({
  selector: 'app-organizer-nav-bar',
  standalone: true,
  imports: [NgClass],
  templateUrl: './organizer-nav-bar.component.html',
  styleUrl: './organizer-nav-bar.component.css'
})
export class OrganizerNavBarComponent implements OnInit {

  @Input() logedInUser: any = new User();
  isDropDownOpen = false;

  constructor(private router:Router, private activeRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(params => {
      this.logedInUser.usertype = params.get('usertype') || 'user';
    });
  }

  toggleDropDown(){
    this.isDropDownOpen = !this.isDropDownOpen;  
  }

  select_method(method: string){
    console.log(this.logedInUser);
    this.router.navigateByUrl(`${this.logedInUser.usertype}/${method}`, {state: this.logedInUser});
  }
}
