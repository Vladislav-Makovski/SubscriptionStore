
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SubscribeModel} from "../modules/header/models/subscribe-model";
import {Observable} from "rxjs/index";

@Injectable()
export class SubscribeService{

  constructor(private http: HttpClient) {}

  subscribeProduct(subProduct: SubscribeModel): Observable<void> {
    return this.http.post<void>('/api/new/subscription/costumer/',subProduct);
  }

}
