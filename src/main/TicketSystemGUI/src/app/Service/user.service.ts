import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../app-classes/User/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiURL = "http://localhost:8080/ticketingsystem";

  constructor(private http: HttpClient) {
    
  }

  passUserData(user: User): Observable<any> {
    console.log(user);
    return this.http.post(this.apiURL,user);
  }
}
