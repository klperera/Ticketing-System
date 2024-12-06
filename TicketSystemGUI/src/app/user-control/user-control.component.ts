import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-control',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-control.component.html',
  styleUrl: './user-control.component.scss'
})
export class UserControlComponent {
  selectedRole: string = ''; // Variable to store user selection

  constructor(private router: Router) {
    
  }

  navigateBasedOnRole(): void {
    console.log('Selected Role:', this.selectedRole);  // Debugging log
    if (this.selectedRole === 'vendor') {
      this.router.navigate(['/Vendor-page']);  // Navigate to vendor page
    } else if (this.selectedRole === 'customer') {
      this.router.navigate(['/Customer-page']);  // Navigate to customer page
    } else {
      alert('Please select a role to proceed.');
    }
  }
    logSelectedRole(): void {
      console.log('Role Selected:', this.selectedRole);
    } // MEKA ONAMA NA

}
