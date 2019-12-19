import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogService} from "../../../../services/catalog.service";
import {Subscription} from "rxjs/index";
import {ProductService} from "../../../../services/product.service";
import {CurrentUserService} from "../../../../services/current-user.service";

@Component({
  selector :'my-product',
  templateUrl: './my-product.component.html',
  styleUrls: ['./my-product.component.css']
})
export class MyProductComponent implements OnInit{

  private subscriptions: Subscription[] = [];
  public myProduct: CatalogItem[] = [];

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService,
              private productService: ProductService,
              private currentUserService: CurrentUserService) {
  }
  ngOnInit(){
    this.loadProduct();
  }

  private loadProduct(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getProductByAdvertiserId(this.currentUserService._currentUser.id).subscribe(accounts => {
      this.myProduct = accounts as CatalogItem[];
      console.log(this.myProduct);
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public pause(id: string): void{
    this.loadingService.show();
    this.subscriptions.push(this.productService.pauseAdvertiserProduct(id).subscribe(() => {
      this.loadProduct();
      this.loadingService.hide();
    }));
  }

}
