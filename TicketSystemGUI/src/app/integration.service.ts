import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConfigureRequest } from './models/configure-request';
import { Observable } from 'rxjs';


const API_URL="http://localhost:8080/api/configure"

@Injectable({
  providedIn: 'root'
})
export class IntegrationService {

  constructor(private http:HttpClient) { }


  Configure (request: ConfigureRequest): Observable<ConfigureRequest>{
    return this.http.post<ConfigureRequest>(API_URL, request);
  }
  
} 


