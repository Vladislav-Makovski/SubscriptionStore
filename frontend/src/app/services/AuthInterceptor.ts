import {Injectable} from "@angular/core";
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs";
import {tap} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router){}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.getItem("token");
    console.log(token);
    const authReq = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' +  token)
    });

    if(token) {
      return next.handle(authReq)
    } else if (req.url === "/api/new/customer" || req.url === "api/authenticate" || req.url === "/api/new/advertiser" || req.url === "/api/bc"|| req.url === "/api/NameAsc") {
      return next.handle(req);
    } else {
      this.router.navigate(['/login']);
      return next.handle(req);
    }
  }
}
