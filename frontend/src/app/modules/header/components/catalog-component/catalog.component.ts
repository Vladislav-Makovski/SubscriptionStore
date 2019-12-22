import {Component, OnInit} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogService} from "../../../../services/catalog.service";
import {SubscribeService} from "../../../../services/subscribe.service";
import {SubscribeModel} from "../../models/subscribe-model";
import {CurrentUserService} from "../../../../services/current-user.service";
import {Router} from "@angular/router";
import {CustomerSubscription} from "../../models/customerSubscription";
import {CustomerSubscriptionService} from "../../../../services/customerSubscription.service";
import {BooModel} from "../../models/boo-model";

@Component({
  selector :'Catalog',
  templateUrl: './catalog.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit{
  public booleanForName: boolean;
  public  booleanForCategory : boolean;
  public booleanForPrice: boolean;
  public subProduct:BooModel[] = [];
  public showParam = false;
  public mySubscription: CustomerSubscription[] = [];
  public catalogItem: CatalogItem[] = [];
  private subscriptions: Subscription[] = [];
  public sub: SubscribeModel = new SubscribeModel();


  constructor(private catalogItemService: CatalogService,
              private subscribeService: SubscribeService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUserService: CurrentUserService,
              private  router: Router,
              private customerSubscription: CustomerSubscriptionService) {
    }

  ngOnInit(){
    this.booleanForName = true;
    this.booleanForCategory = false;
    this.booleanForPrice = false;
    this.loadCatalogItemByNameAsc();
  }

  private loadCatalogItemByNameAsc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByNameAsc().subscribe(accounts => {
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

  private loadCatalogItemByNameDesc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByNameDesc().subscribe(accounts => {
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

  private loadCatalogItemByCategoryAsc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByCategoryAsc().subscribe(accounts => {
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

  private loadCatalogItemByCategoryDesc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByCategoryDesc().subscribe(accounts => {
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

  private loadCatalogItemByPriceAsc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByPriceAsc().subscribe(accounts => {
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

  private loadCatalogItemByPriceDesc(): void {
    this.showParam = false;
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItemByPriceDesc().subscribe(accounts => {
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

  public unsubscribe(id :string): void{
    this.router.navigate(['/subscription'])
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
