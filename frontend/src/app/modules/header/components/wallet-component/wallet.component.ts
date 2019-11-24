import {Component, OnInit} from '@angular/core';
import {UserSignature} from "../../../../UserInformation/user-signature";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {WalletService} from "../../../../services/wallet.service";
import {Wallet} from "../../models/wallet";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector :'wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit{

  public currentUser: UserSignature = new UserSignature();
  public currentWallet: Wallet = new Wallet();
  private subscriptions: Subscription[] = [];

  constructor(private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  ngOnInit(){
    this.loadUserWallet(this.currentUser.walletId);
  }

  private loadUserWallet(walletUserId: string): void {
    this.loadingService.show();


    this.subscriptions.push(this.walletService.getWalletById(walletUserId).subscribe(accounts => {

      this.currentWallet = accounts as Wallet;
      console.log(this.currentWallet);
      this.loadingService.hide();
    }));
  }


  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
