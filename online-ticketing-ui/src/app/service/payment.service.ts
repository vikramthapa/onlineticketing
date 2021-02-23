import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router'

export class Settlement{
  constructor(
    public reservationId: number,
    public paymentSource: string,
    public amountPayable: number 
    )
  {}
}
@Injectable({
  providedIn: 'root'
})
export class PaymentService {
httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };
  constructor(private httpClient:HttpClient, private router:Router) { }
  saveSettlement(reservationId:number,paymentSource:string,amountPayable:number)
   {
      const data = JSON.stringify({'reservationId':reservationId,'paymentSource':paymentSource,
     'amountPayable':amountPayable})
      return this.httpClient.post<any>('http://localhost:8080/api/payment/create',data , this.httpOptions)
   }
   
}
