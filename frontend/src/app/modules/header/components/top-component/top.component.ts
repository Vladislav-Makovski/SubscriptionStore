import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {CatalogService} from "../../../../services/catalog.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs/index";

@Component({
  selector :'top-site',
  templateUrl: './top.component.html',
  styleUrls: ['./top.component.css']
})
export class TopComponent implements OnInit{

  public catalogItem: CatalogItem[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService) {
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
}
