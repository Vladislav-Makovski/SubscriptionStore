import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CatalogItem} from "../modules/header/models/catalog-item";

@Injectable()
export class CatalogService {

  constructor(private http: HttpClient) {
  }

  getCatalogItemByNameAsc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/NameAsc');
  }

  getCatalogItemByNameDesc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/NameDesc');
  }

  getCatalogItemByCategoryAsc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/CategoryAsc');
  }

  getCatalogItemByCategoryDesc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/CategoryDesc');
  }

  getCatalogItemByPriceAsc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/PriceAsc');
  }

  getCatalogItemByPriceDesc(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/PriceDesc');
  }

  getCatalogItemBySubscriptionCount(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/bc');
  }

  getProductByAdvertiserId(id: string): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/advertiser/product/' + id);
  }

}
