import {Component, OnInit} from '@angular/core';
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ProductService} from "../../../../services/product.service";
import {Product} from "../../models/product";
import {Subscription} from "rxjs/index";

@Component({
  selector :'product-confirm',
  templateUrl: './product-confirm.component.html',
  styleUrls: ['./product-confirm.component.css']
})
export class ProductConfirmComponent implements OnInit{
  private subscriptions: Subscription[] = [];
  private siteProduct: Product[] = [];

  constructor(private productService: ProductService,
              private loadingService: Ng4LoadingSpinnerService) {
  }
  ngOnInit(){
    this.loadProduct();
  }

  private loadProduct(): void {
    this.loadingService.show();
    this.subscriptions.push(this.productService.getNewProduct().subscribe(accounts => {
      this.siteProduct = accounts as Product[];
      this.loadingService.hide();
    }));
  }

  public deleteProduct(id: string):void{
    this.loadingService.show();
    this.subscriptions.push(this.productService.deleteNewProduct(id).subscribe(() => {
      this.loadProduct();
      this.loadingService.hide();
    }));
  }

  public confirmProduct(id: string):void{
    this.loadingService.show();
    this.subscriptions.push(this.productService.confirmNewProduct(id).subscribe(() => {
      this.loadProduct();
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
