import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {CatalogService} from "../../../../services/catalog.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs/index";
import {Router} from "@angular/router";
import {CurrentUserService} from "../../../../services/current-user.service";
import {SubscribeService} from "../../../../services/subscribe.service";
import {SubscribeModel} from "../../models/subscribe-model";

@Component({
  selector :'top-site',
  templateUrl: './top.component.html',
  styleUrls: ['./top.component.css']
})
export class TopComponent implements OnInit{

  public catalogItem: CatalogItem[] = [];
  private subscriptions: Subscription[] = [];
  public sub: SubscribeModel = new SubscribeModel();

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUserService: CurrentUserService,
              private  router: Router,
              private subscribeService: SubscribeService) {
  }

  ngOnInit(){
    this.loadCatalogItemBySubscriptionCount();
  }

  private loadCatalogItemBySubscriptionCount(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemBySubscriptionCount().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
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

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
