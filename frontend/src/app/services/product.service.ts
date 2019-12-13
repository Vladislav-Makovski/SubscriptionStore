import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Product} from "../modules/header/models/product";

@Injectable()
export class ProductService{

  constructor(private http: HttpClient) {
  }

  getProductByNameAsc(): Observable<Product[]> {
    return this.http.get<Product[]>('/api/product/byNameAsc');
  }

  deleteProduct(productId: string): Observable<void> {
    return this.http.delete<void>('/api/product/delete/' + productId);
  }

  getNewProduct(): Observable<Product[]>{
    return this.http.get<Product[]>('/api/product/new/product');
  }

  deleteNewProduct(productId: string): Observable<void> {
    return this.http.delete<void>('/api/product/new/delete/' + productId);
  }

  confirmNewProduct(productId: string): Observable<void> {
    return this.http.post<void>('/api/product/new/confirm/', productId);
  }

  pauseAdvertiserProduct(productId: string): Observable<void> {
    return this.http.post<void>('/api/product/advertiser/pause/',productId)

  }

}
