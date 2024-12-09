import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../app-classes/User/user';
import { Observable } from 'rxjs';
import { Event } from '../app-classes/Event/event';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = 'http://localhost:8080/ticketsystem';

  constructor(private http: HttpClient) {}


  user_method(user: User, method: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/${user.usertype}/${method}`,user);
  }
  event_method(event: Event, method: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/${event.organizer.usertype}/${method}`,event);
  }
  
}
