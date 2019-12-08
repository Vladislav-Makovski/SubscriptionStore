import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Advertiser} from "../modules/header/models/advertiser";

@Injectable()
export class AdvertiserService{
  constructor(private http: HttpClient) {
  }

  getAdvertiserByNameAsc(): Observable<Advertiser[]> {
    return this.http.get<Advertiser[]>('/api/advertiser/byNameAsc');
  }

  deleteAdvertiser(id: string): Observable<void> {
    return this.http.delete<void>('/api/advertiser/delete/'+ id);
  }
}
