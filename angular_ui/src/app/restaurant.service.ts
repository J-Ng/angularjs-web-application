import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class RestaurantService {

  private baseUrl = 'http://localhost:8080/api/';

  private headerDict = {
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET, POST, DELETE, PUT, PATCH, HEAD",
    "Access-Control-Allow-Headers": "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers",
    "Access-Control-Expose-Headers": "Access-Control-Allow-Origin, Access-Control-Allow-Credentials",
    "Access-Control-Allow-Credentials": "true",
  }

  private requestOptions = {
    headers: new HttpHeaders(this.headerDict),
  };

  constructor(private http:HttpClient) { }

  getRestaurantList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'restaurants-list', this.requestOptions);
  }

  createRestaurant(restaurant: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'save-restaurant', restaurant);
  }

  deleteRestaurant(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-restaurant/${id}`, { responseType: 'text' });
  }

  getRestaurant(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/restaurant/${id}`);
  }

  updateRestaurant(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/update-restaurant/${id}`, value);
  }

}
