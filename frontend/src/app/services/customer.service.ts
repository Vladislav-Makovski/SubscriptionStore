import {Injectable} from "@angular/core";
import {Customer} from "../modules/header/models/customer";
import {Observable} from "rxjs/index";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class CustomerService{
  constructor(private http: HttpClient) {
  }

  getCustomerByNameAsc(): Observable<Customer[]> {
    return this.http.get<Customer[]>('/api/customer/byNameAsc');
  }
}
