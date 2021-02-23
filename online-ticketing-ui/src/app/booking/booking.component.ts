import { Component, OnInit } from '@angular/core';
import { BookingService} from '../service/booking.service'
import { Router} from '@angular/router';
import { FormGroup, FormControl} from '@angular/forms'
import { HttpClientService, Pilot } from '../service/http-client.service'

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.sass']
})
export class BookingComponent implements OnInit {

  constructor(private pilotService: HttpClientService,
    private router:Router ,
    private bookingService:BookingService) { }

  pilots: Pilot[]|undefined

  requestPilotList(response: Pilot[])
  {
    this.pilots = response;
  }

  getPilots()
  {
    this.pilotService.getPilots().subscribe(
      response => this.requestPilotList(response)
    )
    return this.pilots
  }

  bookingData = new FormGroup(
    {
       pilotId: new FormControl(''),
       firstName: new FormControl(''),
       lastName: new FormControl(''), 
       contact:new FormControl(''), 
       email: new FormControl(''), 
       gender: new FormControl(''),
       age:new FormControl(''),
       date:new FormControl(''),
       prefTime:new FormControl(''),
       durationHour:new FormControl(''),
       durationMinute:new FormControl(''),
    })

    bookMyTicket()
    {
        this.bookingService.saveTicket(
        this.bookingData.controls['pilotId'].value,
        this.bookingData.controls['firstName'].value,
        this.bookingData.controls['lastName'].value,
        this.bookingData.controls['contact'].value,
        this.bookingData.controls['email'].value,
        this.bookingData.controls['gender'].value,
        this.bookingData.controls['age'].value,
        this.bookingData.controls['date'].value,
        this.bookingData.controls['prefTime'].value,
        this.bookingData.controls['durationHour'].value,
        this.bookingData.controls['durationMinute'].value,
      ).subscribe(
        response => {
          const id = parseInt(response)
          alert("Ticket Booked with ID: "+id); 
          sessionStorage.setItem('refId',id+'');
          console.log(response)
          this.router.navigate(['/payment'])
        },
        error =>{
           console.log(error)}
      );
      
      console.log(this.bookingData)
    }

  ngOnInit(): void {
    this.getPilots()
  }
}
