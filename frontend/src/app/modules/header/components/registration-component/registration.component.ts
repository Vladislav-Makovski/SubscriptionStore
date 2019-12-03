import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {RegistrationModel} from "../../models/registration-model";
import {Subscription} from "rxjs/index";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {WalletService} from "../../../../services/wallet.service";
import {RegistrationService} from "../../../../services/registration.service";
import {UserSignature} from "../../../../UserInformation/user-signature";

@Component({
  selector: 'my-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  myFormUser: FormGroup;
  public userRegistrationTypes = ["Customer", "Advertiser"];
  public user :UserSignature = new UserSignature();
  public currentRegistrationType: string = this.userRegistrationTypes[0];
  public  userInformation: RegistrationModel = new RegistrationModel();
  private subscriptions: Subscription[] = [];

  constructor(private registrationService: RegistrationService,
              private loadingService: Ng4LoadingSpinnerService) {
  }


  ngOnInit() {
    this.myFormUser = new FormGroup({
      "email": new FormControl("", [Validators.required, Validators.email]),
      "password": new FormControl("", Validators.required),
      "nickname": new FormControl("", Validators.required),
      "name": new FormControl("", Validators.required),
      "surname": new FormControl("", Validators.required),
    });
  }

  submitUser():void {
    if(this.currentRegistrationType == this.userRegistrationTypes[0]){
      this.userInformation.username = this.myFormUser.controls['nickname'].value;
      this.userInformation.password = this.myFormUser.controls['password'].value;
      this.userInformation.email = this.myFormUser.controls['email'].value;
      this.userInformation.userRoleId = "1";
      this.userInformation.firstName = this.myFormUser.controls['name'].value;
      this.userInformation.surname = this.myFormUser.controls['surname'].value;
      this.userInformation.balance = "0";
      this.userInformation.statusWalletId = "1";
      this.loadingService.show();
      this.subscriptions.push(this.registrationService.saveNewCustomer(this.userInformation).subscribe(accounts => {
        this.user = accounts as UserSignature ;
        console.log(this.user);
        this.loadingService.hide();
      }));
    }
  }

  onChange(value: string) {
    this.currentRegistrationType = value;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
