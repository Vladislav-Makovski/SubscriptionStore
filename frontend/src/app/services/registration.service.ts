import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {RegistrationModel} from "../modules/header/models/registration-model";
import {UserSignature} from "../UserInformation/user-signature";
import {Observable} from "rxjs/index";

@Injectable()
export class RegistrationService{

  constructor(private http: HttpClient) {}

  saveNewCustomer(userInf: RegistrationModel): Observable<UserSignature> {
    return this.http.post<UserSignature>('/api/new/customer',userInf);
  }

}
