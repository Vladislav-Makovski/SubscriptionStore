import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CatalogItem} from "../modules/header/models/catalog-item";

@Injectable()
export class CatalogService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getCatalogItem(): Observable<CatalogItem[]> {
    return this.http.get<CatalogItem[]>('/api/ba');
  }
  
  getCatalogItemById(id: string): Observable<CatalogItem> {
    return this.http.get<CatalogItem>('/api/ba/' + id);
  }

}
