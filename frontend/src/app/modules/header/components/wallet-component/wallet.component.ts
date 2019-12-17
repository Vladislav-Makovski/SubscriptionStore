import {Component, OnInit} from '@angular/core';
import {UserSignature} from "../../../../UserInformation/user-signature";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {WalletService} from "../../../../services/wallet.service";
import {Wallet} from "../../models/wallet";
import {Subscription} from "rxjs/internal/Subscription";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {WalletUpdate} from "../../models/walletUpdate";
import {DefultUser} from "../../../../UserInformation/defult-user";
import {AuthInterceptor} from "../../../../services/AuthInterceptor";

@Component({
  selector :'wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css'],
  providers:[AuthInterceptor]
})
export class WalletComponent implements OnInit{

  public currentUser: DefultUser = new DefultUser();
  public currentWallet: Wallet = new Wallet();
  private subscriptions: Subscription[] = [];
  myFormWallet: FormGroup;
  rechargeWallet : WalletUpdate = new WalletUpdate();

  constructor(private walletService: WalletService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  ngOnInit(){
    this.myFormWallet = new FormGroup({
      "total": new FormControl("1", [Validators.required,Validators.min(1)]),
    });
    this.loadUserWallet(this.currentUser.walletId);
  }

  private loadUserWallet(walletUserId: string): void {
    this.loadingService.show();


    this.subscriptions.push(this.walletService.getWalletById(walletUserId).subscribe(accounts => {
      this.currentWallet = accounts as Wallet;
      this.loadingService.hide();
    }));
  }

   walletRecharge():void{

     this.rechargeWallet.id = this.currentWallet.id;
     this.rechargeWallet.statusWalletId = "1";
      this.rechargeWallet.balance =  this.currentWallet.balance + this.myFormWallet.controls['total'].value;
     console.log(this.rechargeWallet);
     this.loadingService.show();
    this.subscriptions.push(this.walletService.saveBalanceRecharge(this.rechargeWallet).subscribe(accounts => {
      this.rechargeWallet = accounts as WalletUpdate;
      this.currentWallet.balance = this.rechargeWallet.balance;
      this.loadingService.hide();

    }));
  }

  walletWithdraw():void{
    if(this.currentWallet.balance <= this.myFormWallet.controls['total'].value){
      console.log('Error');
    }else{
      this.rechargeWallet.id = this.currentWallet.id;
      this.rechargeWallet.statusWalletId = "1";
      this.rechargeWallet.balance =  this.currentWallet.balance - this.myFormWallet.controls['total'].value;
      this.loadingService.show();
      this.subscriptions.push(this.walletService.saveBalanceWithdraw(this.rechargeWallet).subscribe(accounts => {
        this.rechargeWallet = accounts as WalletUpdate;
        this.currentWallet.balance = this.rechargeWallet.balance;
        this.loadingService.hide();

      }));
    }

  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
