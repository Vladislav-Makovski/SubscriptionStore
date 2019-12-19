import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/index";
import {CustomerSubscription} from "../../models/customerSubscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CustomerSubscriptionService} from "../../../../services/customerSubscription.service";
import {CurrentUserService} from "../../../../services/current-user.service";

@Component({
  selector :'subscription-page',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit{
  public mySubscription: CustomerSubscription[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private customerSubscription: CustomerSubscriptionService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUserService: CurrentUserService) {
  }
  ngOnInit() {
    this.loadSubscription();
  }

  private loadSubscription(): void {
    this.loadingService.show();
    this.subscriptions.push(this.customerSubscription.getSubscriptionByUserId(this.currentUserService._currentUser.id).subscribe(accounts => {
      this.mySubscription = accounts as CustomerSubscription[];
      console.log(this.mySubscription);
      this.loadingService.hide();
    }));
  }

  public unsubscribe(id :string): void{
    this.loadingService.show();
    this.subscriptions.push(this.customerSubscription.deleteSubscription(id).subscribe(() => {
      this.updateCustomerSubscription();
    }));
  }


  public updateCustomerSubscription(): void {
    this.loadSubscription();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
