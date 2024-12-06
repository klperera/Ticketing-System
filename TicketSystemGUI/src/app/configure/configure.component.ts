import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IntegrationService } from '../integration.service';
import { ConfigureRequest } from '../models/configure-request';

@Component({
  selector: 'app-configure',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './configure.component.html',
  styleUrls: ['./configure.component.scss']
})
export class ConfigureComponent {
  vendorId?: number;
  ticketsPerRelease?: number;
  releaseInterval?: number;

  // Inject IntegrationService
  constructor(private IntegrationService: IntegrationService) {}

  // Method to handle form submission
  submitConfiguration(): void {
    console.log('Form Submitted');
    const request: ConfigureRequest = {
      vendorId: this.vendorId,
      ticketsPerRelease: this.ticketsPerRelease,
      releaseInterval: this.releaseInterval
    };

    // Call the service method to submit the configuration
    this.IntegrationService.Configure(request).subscribe({
      next: (response: any) => {
        console.log('Response from backend:', response);
        alert('Configuration submitted successfully!');
      },
      error: (error: any) => {
        console.error('Error occurred:', error);
        alert('Failed to submit configuration. Please try again.');
      }
    });
  }

  // Methods to update individual fields (if necessary)
  updateVendorId(value: string): void {
    this.vendorId = Number(value);
  }

  updateTicketsPerRelease(value: string): void {
    this.ticketsPerRelease = Number(value);
  }

  updateReleaseInterval(value: string): void {
    this.releaseInterval = Number(value);
  }

  
}
