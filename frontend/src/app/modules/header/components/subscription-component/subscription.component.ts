import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/index";
import {CustomerSubscription} from "../../models/customerSubscription";
import {CatalogService} from "../../../../services/catalog.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CustomerSubscriptionService} from "../../../../services/customerSubscription.service";
import {UserSignature} from "../../../../UserInformation/user-signature";

@Component({
  selector :'subscription-page',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit{

  public currentUser: UserSignature = new UserSignature();
  public mySubscription: CustomerSubscription[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private customerSubscription: CustomerSubscriptionService,
              private loadingService: Ng4LoadingSpinnerService) {
  }
  ngOnInit() {
    this.loadSubscription();
  }
  private loadSubscription(): void {
    this.loadingService.show();
    this.subscriptions.push(this.customerSubscription.getSubscriptionByUserId(this.currentUser.id).subscribe(accounts => {
      this.mySubscription = accounts as CustomerSubscription[];
      console.log(this.mySubscription);
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
