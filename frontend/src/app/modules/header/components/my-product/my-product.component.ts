import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogService} from "../../../../services/catalog.service";
import {Subscription} from "rxjs/index";
import {DefultAdvertiser} from "../../../../UserInformation/defult-advertiser";
import {ProductService} from "../../../../services/product.service";

@Component({
  selector :'my-product',
  templateUrl: './my-product.component.html',
  styleUrls: ['./my-product.component.css']
})
export class MyProductComponent implements OnInit{

  private subscriptions: Subscription[] = [];
  public myProduct: CatalogItem[] = [];
  public currentAdvertiser: DefultAdvertiser = new DefultAdvertiser();

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService,
              private productService: ProductService) {
  }
  ngOnInit(){
    this.loadProduct();
  }

  private loadProduct(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getProductByAdvertiserId(this.currentAdvertiser.id).subscribe(accounts => {
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
