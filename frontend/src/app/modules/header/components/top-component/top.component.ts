import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {CatalogService} from "../../../../services/catalog.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs/index";
import {Router} from "@angular/router";
import {CurrentUserService} from "../../../../services/current-user.service";
import {SubscribeService} from "../../../../services/subscribe.service";
import {SubscribeModel} from "../../models/subscribe-model";
import {CustomerSubscriptionService} from "../../../../services/customerSubscription.service";
import {CustomerSubscription} from "../../models/customerSubscription";

@Component({
  selector :'top-site',
  templateUrl: './top.component.html',
  styleUrls: ['./top.component.css']
})
export class TopComponent implements OnInit{

  public catalogItem: CatalogItem[] = [];
  private subscriptions: Subscription[] = [];
  public sub: SubscribeModel = new SubscribeModel();
  public mySubscription: CustomerSubscription[] = [];
  public showParam = false;

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUserService: CurrentUserService,
              private  router: Router,
              private subscribeService: SubscribeService,
              private customerSubscription: CustomerSubscriptionService) {
  }
  ngOnInit(){
    this.loadCatalogItemBySubscriptionCount();
  }

  private loadCatalogItemBySubscriptionCount(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemBySubscriptionCount().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      if(this.currentUserService._currentUser.userRole !== "guest"){
        this.loadSubscription();
      }else{
        for(let i = 0; i < this.catalogItem.length;i++){
          this.catalogItem[i].cond = "false";
        }
        this.showParam = true;
      }
      this.loadingService.hide();
    }));
  }

  public subscribeProduct(id: string): void{
    if(this.currentUserService._currentUser.userRole == 'guest'){
      this.router.navigate(['/login']);
    }else {
      this.sub.userId = this.currentUserService._currentUser.id;
      this.sub.statusSubId = "1";
      this.sub.productId = id;
      this.loadingService.show();
      this.subscriptions.push(this.subscribeService.subscribeProduct(this.sub).subscribe(() => {
        this.router.navigate(['/subscription']);
        this.loadingService.hide();
      }));
    }
  }

  private loadSubscription(): void {
    this.loadingService.show();
    this.subscriptions.push(this.customerSubscription.getSubscriptionByUserId(this.currentUserService._currentUser.id).subscribe(accounts => {
      this.mySubscription = accounts as CustomerSubscription[];
      console.log(this.mySubscription);
      this.fillSubProduct();
      this.loadingService.hide();
    }));
  }

  public fillSubProduct(){
    for(let i = 0 ;i< this.catalogItem.length; i++){
      this.catalogItem[i].cond = 'false';
      for(let j = 0; j <this.mySubscription.length;j++){
        if(this.catalogItem[i].name === this.mySubscription[j].name){
          this.catalogItem[i].cond = 'true';
        }
      }
      console.log(this.catalogItem[i].cond);
    }
    this.showParam = true;
  }

  public unsub():void{
    this.router.navigate(['/subscription'])
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
