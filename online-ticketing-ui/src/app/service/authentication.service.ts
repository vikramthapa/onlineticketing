import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router'

export class User{
  constructor(
    public status:string
     ) {}
  
}

export class JwtRequest{
  constructor(public username:string,public password:string){}
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
  
}


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };
  constructor(
    private httpClient:HttpClient, private router:Router
  ) { 
     }

    authenticate(username:string, password:string){
      this.httpClient.post<any>('http://localhost:8080/authenticate', JSON.stringify({'username':username,'password':password}), this.httpOptions).subscribe(
        response => {
          const tokenStr = 'Bearer '+ response.token;
          sessionStorage.setItem('token',tokenStr)
          sessionStorage.setItem('username',username)
          this.router.navigate(['/dashboard'])
        },
        error =>{
          this.logOut()
           console.log(error)}
      );
    }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('token')
  }
}
