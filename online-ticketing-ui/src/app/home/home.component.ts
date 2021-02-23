import { Component, OnInit } from '@angular/core';
import { HttpClientService, Pilot } from '../service/http-client.service'
import { AuthenticationService} from '../service/authentication.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})

export class HomeComponent implements OnInit {

  pilots: Pilot[]|undefined;

  constructor(
    private httpClientService:HttpClientService, private authentication:AuthenticationService
  ) {}
  performLogin()
  {
    console.log("Athenticating...")
    let value = this.authentication.authenticate("admin","password")
    console.log("Token Recieved: "+sessionStorage.getItem('token'))
  }
  ngOnInit(): void {
      
  }


  requestPilotList(response: Pilot[])
  {
    this.pilots = response;
  }
  getPilots()
  {
    this.httpClientService.getPilots().subscribe(
      response => this.requestPilotList(response)
    )
    console.log("Token Recieved: "+sessionStorage.getItem('token'))
    console.log("User:"+sessionStorage.getItem('username'))

    return this.pilots
  }

}
