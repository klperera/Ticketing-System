import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../app-classes/User/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private organizer_register_ApiUrl  = 'http://localhost:8080/ticketsystem/organizer/register';
  private organizer_login_ApiUrl  = 'http://localhost:8080/ticketsystem/organizer/login';

  private vendor_register_ApiUrl  = 'http://localhost:8080/ticketsystem/vendor/register';
  private vendor_login_ApiUrl  = 'http://localhost:8080/ticketsystem/vendor/login';

  private customer_register_ApiUrl  = 'http://localhost:8080/ticketsystem/vendor/register';
  private customer_login_ApiUrl  = 'http://localhost:8080/ticketsystem/customer/login';

  constructor(private http: HttpClient) {}

  
  organizer_register(user: User): Observable<any> {
    return this.http.post(this.organizer_register_ApiUrl,user);
  }
  organizer_login(user: User): Observable<any> {
    return this.http.post(this.organizer_login_ApiUrl,user);
  }

  vendor_register(user: User): Observable<any> {
    return this.http.post(this.vendor_register_ApiUrl,user);
  }
  vendor_login(user: User): Observable<any> {
    return this.http.post(this.vendor_login_ApiUrl,user);
  }

  customer_register(user: User): Observable<any> {
    return this.http.post(this.customer_register_ApiUrl,user);
  }
  customer_login(user: User): Observable<any> {
    return this.http.post(this.customer_login_ApiUrl,user);
  }
}
