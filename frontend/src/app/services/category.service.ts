import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../modules/header/models/category";

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {
  }

  getCategory(): Observable<Category[]> {
    return this.http.get<Category[]>('/api/bi');
  }

}
