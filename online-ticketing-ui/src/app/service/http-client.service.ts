import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

export class Pilot{
  constructor(
    public ptid: number,
    public firstName: string,
    public lastName: string, 
    private male: boolean,
    private licensed:boolean,
    private expertise:string,
    private venue:string,
    private location:string,
    private about:string,
    private imageUrl:string
    )
  {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor( private httpClient:HttpClient)
  {}

  getPilots(){
    console.log("Requesting for pilot lists...")
    return this.httpClient.get<Pilot[]>('http://localhost:8080/api/pilot/all')
  }
}
