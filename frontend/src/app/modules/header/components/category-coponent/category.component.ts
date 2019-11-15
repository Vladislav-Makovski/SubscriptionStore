import {Component, OnInit} from '@angular/core';
import {Category} from "../../models/category";
import {CatalogItem} from "../../models/catalog-item";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CategoryService} from "../../../../services/category.service";
import {Subscription} from "rxjs/index";
import {CatalogService} from "../../../../services/catalog.service";

@Component({
  selector :'category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{

  public catalogItem: CatalogItem[] = [];
  public category: Category[] = [];
  public viewCategory: string[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private catalogItemService: CatalogService,
              private categoryService: CategoryService,
              private loadingService: Ng4LoadingSpinnerService,) {
  }
  ngOnInit(){

    this.loadCatalogItemByCategory();
  }

  private loadCatalogItemByCategory(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByCategoryId().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadCategory();
      this.loadingService.hide();
    }));
  }

  private loadCategory(): void {
    this.loadingService.show();
    this.subscriptions.push(this.categoryService.getCategory().subscribe(accounts => {
      this.category = accounts as Category[];
      console.log(this.category);
      this.fillCategory();
      this.loadingService.hide();
    }));
  }

  private fillCategory():void{
    for (let i = 0; i < this.catalogItem.length;i++ ){
      for(let j = 0; j < this.category.length;j++){
        if(this.catalogItem[i].categoryId === this.category[j].id) {
          this.viewCategory.push(this.category[j].name);
          console.log(this.viewCategory[i])
        }
      }
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
