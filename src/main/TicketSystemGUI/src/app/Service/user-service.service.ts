import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../app-classes/User/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = 'http://localhost:8080/ticketsystem';

  constructor(private http: HttpClient) {}


  user_method(user: User, method: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/${user.usertype}/${method}`,user);
  }
  
}
