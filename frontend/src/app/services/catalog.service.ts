import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CatalogItem} from "../modules/header/models/catalog-item";

@Injectable()
export class CatalogService {

  constructor(private http: HttpClient) {
  }

  getCatalogItemByCategoryId(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/bb');
  }

  getCatalogItemByName(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/ba');
  }

  getCatalogItemBySubscriptionCount(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/bc');
  }

}
