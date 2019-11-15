import {Component, OnInit, TemplateRef} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Category} from "../../models/category";
import {CategoryService} from "../../../../services/category.service";
import {CatalogService} from "../../../../services/catalog.service";

@Component({
  selector :'Catalog',
  templateUrl: './catalog.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit{

  public catalogItem: CatalogItem[] = [];
  public category: Category[] = [];
  public viewCategory: string[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private catalogItemService: CatalogService,
              private categoryService: CategoryService,
              private loadingService: Ng4LoadingSpinnerService,) {
    }

  ngOnInit(){

    this.loadCatalogItem();
  }

  private loadCatalogItem(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByName().subscribe(accounts => {
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
