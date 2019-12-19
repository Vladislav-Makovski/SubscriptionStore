import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserSignature} from "../UserInformation/user-signature";
import {Observable} from "rxjs/index";
import {RegistrationCustomer} from "../modules/header/models/registration-customer";
import {RegistrationAdvertiser} from "../modules/header/models/registration-advertiser";
import {map} from "rxjs/internal/operators";

@Injectable()
export class RegistrationService{

  constructor(private http: HttpClient) {}

  saveNewCustomer(userInf: RegistrationCustomer): Observable<UserSignature> {
    return this.http.post<UserSignature>('/api/new/customer',userInf);
  }

  saveNewAdvertiser(userInf: RegistrationAdvertiser): Observable<UserSignature> {
    return this.http.post<UserSignature>('/api/new/advertiser',userInf);
  }
}
