import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/index";
import {Product} from "../../models/product";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ProductService} from "../../../../services/product.service";

@Component({
  selector :'product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit{
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
    this.subscriptions.push(this.productService.getProductByNameAsc().subscribe(accounts => {
      this.siteProduct = accounts as Product[];
      console.log(this.siteProduct);
      this.loadingService.hide();
    }));
  }

  public deleteProduct(id: string):void{
    this.loadingService.show();
    this.subscriptions.push(this.productService.deleteProduct(id).subscribe(() => {
      this.loadProduct();
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
