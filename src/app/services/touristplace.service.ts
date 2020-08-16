import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TouristPlaceService {
  private baseUrl = 'http://localhost:8080';
  private postUrl='http://localhost:8080/add';
  constructor(private http:HttpClient) { }
  
  getPlaceList(): Observable<any> {
    return this.http.get(this.baseUrl+"/touristplaces");
  }
  createTouristPlace(touristplace:Object): Observable<Object> 
  {
    return this.http.post(this.postUrl,touristplace);
  }
  getPlaceByName(name:string):Observable<any>
  {
    return this.http.get(this.baseUrl+'/place-by-name/'+name);
  }
  getPlaceByCity(city:string):Observable<any>
  {
    return this.http.get(this.baseUrl+'/place-by-city/'+city);
  }
  getPlaceByState(state:string):Observable<any>
  {
    return this.http.get(this.baseUrl+'/place-by-state/'+state);
  }
  deletePlace(id:number):Observable<any>
  {
    return this.http.delete(this.baseUrl+'/delete-TouristPlace/'+id);
  }
  /*
  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }
 */
}
