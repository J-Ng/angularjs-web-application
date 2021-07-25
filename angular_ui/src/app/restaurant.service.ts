import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class RestaurantService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  getRestaurantList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'restaurants-list');
  }

  createRestaurant(student: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'save-restaurant', student);
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
