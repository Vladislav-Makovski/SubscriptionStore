import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AddProductModel} from "../modules/header/models/add-product-model";
import {Observable} from "rxjs/index";

@Injectable()
export class AddProductService{

  constructor(private http: HttpClient) {
  }

  saveNewProduct(prod: AddProductModel): Observable<void> {
    return this.http.post<void>('/api/product/new/', prod);
  }
}
