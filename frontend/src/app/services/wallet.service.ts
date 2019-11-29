import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wallet} from "../modules/header/models/wallet";
import {WalletUpdate} from "../modules/header/models/walletUpdate";

@Injectable()
export class WalletService {

  constructor(private http: HttpClient) {
  }

  getWalletById(id: string): Observable<Wallet> {
    return this.http.get<Wallet>('/api/walletById/' + id);
  }

  saveBalanceRecharge(wallet: WalletUpdate): Observable<WalletUpdate> {
    return this.http.post<WalletUpdate>('/api/recharge',wallet);
  }

  saveBalanceWithdraw(wallet: WalletUpdate): Observable<WalletUpdate>{
    return this.http.post<WalletUpdate>('/api/withdraw',wallet)
  }
}
