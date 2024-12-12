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

  user: User = new User();
  requiredData: any = {};

  constructor(private http: HttpClient) {}


  user_method(user: User, method: string): Observable<any> {
    this.user = user;
    console.log(user);
    return this.http.post(`${this.baseUrl}/${user.usertype}/${method}`,user);
  }
  event_method(event: Event, method: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/${event.organizer.usertype}/${method}`,event);
  }
  purchaseTickets_method(sendDetails: any, method: string): Observable<any> {
    console.log(sendDetails);
    return this.http.post(`${this.baseUrl}/${sendDetails.logedInUser.usertype}/${method}`,sendDetails);
  }
  addToTicketPool(sendDetails: any, method: string): Observable<any> {
    console.log(sendDetails);
    this.requiredData.eventID = sendDetails.event.eventID;
    this.requiredData.vendorID = sendDetails.logedInUser.vendorId;
    this.requiredData.earlyBirdTicket = sendDetails.ticketDetails.earlyBirdTicket;
    this.requiredData.generalTicket = sendDetails.ticketDetails.generalTicket;
    this.requiredData.lastMinuteTicket = sendDetails.ticketDetails.lastMinuteTicket;
    console.log(this.requiredData);
    return this.http.post(`${this.baseUrl}/${sendDetails.logedInUser.usertype}/${method}`,this.requiredData);
  }
  
}
