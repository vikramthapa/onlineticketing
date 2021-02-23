import { Component, OnInit } from '@angular/core';
import { AuthenticationService} from '../service/authentication.service'
import { Router} from '@angular/router';
import { FormGroup, FormControl} from '@angular/forms'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  constructor(private authentication: AuthenticationService,private router:Router) { }

  loginData = new FormGroup(
    {
      username: new FormControl(''),
      password: new FormControl('')
    }
  )

  performLogin()
  {
    this.authentication.authenticate(this.loginData.controls['username'].value,this.loginData.controls['password'].value)
    
  }

  ngOnInit(): void {
  }

}
