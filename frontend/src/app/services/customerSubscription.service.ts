import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {CustomerSubscription} from "../modules/header/models/customerSubscription";

@Injectable()
export class CustomerSubscriptionService{

  constructor(private http: HttpClient) {
  }

  getSubscriptionByUserId(id: string): Observable<CustomerSubscription[]> {
    return this.http.get<CustomerSubscription[]>('/api/customerSubscription/' + id);
  }

  deleteSubscription(subscriptionId: string): Observable<void> {
    return this.http.delete<void>('/api/customerSubscription/delete/' + subscriptionId);
  }

}
