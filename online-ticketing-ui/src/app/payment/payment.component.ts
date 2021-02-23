import { Component, OnInit } from '@angular/core';
import { BookingService,Booking} from '../service/booking.service'
import { PaymentService} from '../service/payment.service'
import { Router} from '@angular/router';
import { FormGroup, FormControl} from '@angular/forms'

export class Settlement{
  constructor(
    public reservationId: number,
    public paymentSource: string,
    public amountPayable: number 
    )
  {}
}

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.sass']
})
export class PaymentComponent implements OnInit {
   constructor(private bookingService: BookingService,
    private router:Router ,
    private paymentService:PaymentService) { }

  booking: Booking|undefined

  requestBooking(response: Booking)
  {
    this.booking = response;
  }

  getBooking()
  {
    const id = sessionStorage.getItem("refId")+""
     this.bookingService.getBooking(id).subscribe(
      response => this.requestBooking(response)
    )
    return this.booking
  }
  settlementData = new FormGroup(
  {
      reservationId: new FormControl(''),
      paymentSource: new FormControl(''),
      amountPayable:new FormControl(''),
  })
  makeSettlement()
  {
    this.paymentService.saveSettlement(
      this.settlementData.controls['reservationId'].value,
      this.settlementData.controls['paymentSource'].value,
      this.settlementData.controls['amountPayable'].value,
    ).subscribe(Booking=>alert("Settlement Made Successfully"))
    
  }
  
  ngOnInit(): void {
  }

}
