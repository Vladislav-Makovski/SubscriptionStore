import {Component, OnInit} from '@angular/core';
import {DefultAdvertiser} from "../../../../UserInformation/defult-advertiser";
import {Subscription} from "rxjs/index";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CategoryService} from "../../../../services/category.service";
import {Category} from "../../models/category";
import {AddProductModel} from "../../models/add-product-model";
import {AddProductService} from "../../../../services/add-product.service";
import {CurrentUserService} from "../../../../services/current-user.service";

@Component({
  selector :'add-product',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit{
  formProduct: FormGroup;
  productCategory: Category[] = [];
  productSave: AddProductModel = new AddProductModel();
  private subscriptions: Subscription[] = [];

  constructor(private categoryService: CategoryService,
              private addProductService: AddProductService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUserService: CurrentUserService) {
  }
  ngOnInit() {
    this.loadCategory();
    this.formProduct = new FormGroup({
      "name": new FormControl("", Validators.required),
      "description": new FormControl("",Validators.required),
      "cost": new FormControl("",Validators.required),
      "category": new FormControl("", Validators.required),
    });
  }

  private loadCategory(): void {
    this.loadingService.show();
    this.subscriptions.push(this.categoryService.getCategory().subscribe(accounts => {
      this.productCategory = accounts as Category[];
      console.log(this.productCategory);
      this.loadingService.hide();
    }));
  }

  private  addProduct():void{
    console.log(this.formProduct);
    this.productSave.name = this.formProduct.controls['name'].value;
    this.productSave.description = this.formProduct.controls['description'].value;
    this.productSave.cost = this.formProduct.controls['cost'].value;
    this.productSave.categoryId = this.productCategory.find(x => x.name == this.formProduct.controls['category'].value).id;
    this.productSave.subscriptionCount = "0";
    this.productSave.statusProductId = "3";
    this.productSave.organizationId = this.currentUserService._currentUser.id;
    console.log(this.productSave.organizationId);
    console.log(this.currentUserService._currentUser.id);

    console.log(this.productSave);
    this.loadingService.show();
    this.subscriptions.push(this.addProductService.saveNewProduct(this.productSave).subscribe(() => {
      console.log("ok");
      this.loadingService.hide();
    }));

  }
}
