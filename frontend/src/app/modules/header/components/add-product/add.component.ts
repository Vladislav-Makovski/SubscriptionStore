import {Component, OnInit} from '@angular/core';
import {DefultAdvertiser} from "../../../../UserInformation/defult-advertiser";
import {Subscription} from "rxjs/index";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CategoryService} from "../../../../services/category.service";
import {Category} from "../../models/category";
import {AddProductModel} from "../../models/add-product-model";
import {log} from "util";
import {AddProductService} from "../../../../services/add-product.service";

@Component({
  selector :'add-product',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit{
  formProduct: FormGroup;
  prod: AddProductModel;
  currentAdvertiser: DefultAdvertiser = new DefultAdvertiser();
  productCategory: Category[] = [];
  productSave: AddProductModel = new AddProductModel();
  private subscriptions: Subscription[] = [];

  constructor(private categoryService: CategoryService,
              private addProductService: AddProductService,
              private loadingService: Ng4LoadingSpinnerService) {
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
    this.productSave.statusProductId = "2";
    this.productSave.organizationId = this.currentAdvertiser.id;
    console.log(this.productSave);
    this.loadingService.show();
    this.subscriptions.push(this.addProductService.saveNewProduct(this.productSave).subscribe(() => {
      // this.prod = accounts as AddProductModel ;
      // console.log(this.prod);
      console.log("ok")
      this.loadingService.hide();
    }));

  }
}
