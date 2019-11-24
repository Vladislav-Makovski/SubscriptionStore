import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wallet} from "../modules/header/models/wallet";

@Injectable()
export class WalletService {

  constructor(private http: HttpClient) {
  }

  getWalletById(id: string): Observable<Wallet> {
    return this.http.get<Wallet>('/api/walletById/' + id);
  }

}
