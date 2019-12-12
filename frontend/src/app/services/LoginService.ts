import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserLogin} from "../modules/header/models/UserLogin";
import {UserSignature} from "../UserInformation/user-signature";
import {Observable} from "rxjs/index";
import {UserTest} from "../UserInformation/user-test";

@Injectable()
export class LoginService{

  constructor(private http: HttpClient) {}

  loginUser(userInf: UserLogin): Observable<UserTest> {
    return this.http.post<UserTest>('api/authenticate',userInf);
  }

}
