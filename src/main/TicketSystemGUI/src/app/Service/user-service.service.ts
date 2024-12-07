import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../app-classes/User/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiUrl  = 'http://localhost:8080/ticketsystem/organizer/register';

  constructor(private http: HttpClient) {}

  
  register(user: User): Observable<any> {
    console.log(user.username)
    return this.http.post(this.apiUrl,user);
  }
}
