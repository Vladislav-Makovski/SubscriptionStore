import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogService} from "../../../../services/catalog.service";

@Component({
  selector :'Catalog',
  templateUrl: './catalog.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit{
  public booleanForName: boolean;
  public  booleanForCategory : boolean;
  public booleanForPrice: boolean;

  public catalogItem: CatalogItem[] = [];
  private subscriptions: Subscription[] = [];


  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService) {
    }

  ngOnInit(){
    this.booleanForName = true;
    this.booleanForCategory = false;
    this.booleanForPrice = false;
    this.loadCatalogItemByNameAsc();
  }

  private loadCatalogItemByNameAsc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByNameAsc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  private loadCatalogItemByNameDesc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByNameDesc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  private loadCatalogItemByCategoryAsc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByCategoryAsc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  private loadCatalogItemByCategoryDesc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByCategoryDesc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  private loadCatalogItemByPriceAsc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByPriceAsc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  private loadCatalogItemByPriceDesc(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByPriceDesc().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  public sortByName(): void{
    if(this.booleanForName){
      this.loadCatalogItemByNameDesc();
      this.booleanForName = !this.booleanForName;
    }
    else {
      this.loadCatalogItemByNameAsc();
      this.booleanForName = !this.booleanForName;
    }

  }

  public sortByCategory(): void{
    if(this.booleanForCategory){
      this.loadCatalogItemByCategoryDesc();
      this.booleanForCategory = !this.booleanForCategory;
    }
    else {
      this.loadCatalogItemByCategoryAsc();
      this.booleanForCategory = !this.booleanForCategory;
    }
  }

  public sortByPrice(): void{
    if(this.booleanForPrice){
      this.loadCatalogItemByPriceDesc();
      this.booleanForPrice = !this.booleanForPrice;
    }
    else {
      this.loadCatalogItemByPriceAsc();
      this.booleanForPrice = !this.booleanForPrice;
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
