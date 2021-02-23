import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router'

export class Booking{
  constructor(
    public pilotId: number,
    public firstName: string,
    public lastName: string, 
    public contact: string, 
    public email: string, 
    private gender: string,
    private age:number,
    private date:string,
    private prefTime:string,
    private durationHour:number,
    private durationMinute:number,
    )
  {}
}
@Injectable({
  providedIn: 'root'
})
export class BookingService {
 httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

 constructor(private httpClient:HttpClient, private router:Router) { }

 saveTicket(pilotId:number,firstName:string,lastName:string,
  contact:string,email:string,gender:string,age:number,date:string,
  prefTime:string,durationHour:string,durationMinute:string)
 {
    const data = JSON.stringify({'pilotId':pilotId,'firstName':firstName,'lastName':lastName,
    'contact':contact,'email':email,'gender':gender,'age':age,'date':date,
    'prefTime':prefTime,'durationHour':durationHour,'durationMinute':durationMinute})

    return this.httpClient.post<any>('http://localhost:8080/api/ticket/create',data , this.httpOptions)
 }
 getBooking(id:string)
 {
    console.log("Requesting for pilot lists...")
    return this.httpClient.get<Booking>('http://localhost:8080/api/ticket/find/'+id,this.httpOptions)
 }
}
