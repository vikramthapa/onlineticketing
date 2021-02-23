import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {
  constructor(private token:string) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
  const userToken = sessionStorage.getItem('token');
  console.log("User Token in Interceptor: "+userToken)
     this.token = userToken!== null ?userToken:'';
    
     if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
       console.log("Interceptor added the bearer to the Requested link.")
       req = req.clone({ headers: req.headers.append('Authorization', this.token) })
     }
     console.log("Interceptor returned")
    return next.handle(req);

  }

}

