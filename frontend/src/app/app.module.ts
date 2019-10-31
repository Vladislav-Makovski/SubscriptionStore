import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {HomeComponent} from "./modules/header/components/home-component/home.component";
import {CatalogComponent} from "./modules/header/components/catalog-component/catalog.component";
import {SubscriptionComponent} from "./modules/header/components/subscription-component/subscription.component";
import {HeaderGuestComponent} from "./modules/header/components/header-guest/header-guest.component";
import {HeaderUserComponent} from "./modules/header/components/header-user/header-user.component";
import {HeaderAdvertiserComponent} from "./modules/header/components/header-advertiser/header-advertiser.component";
import {FooterComponent} from "./modules/header/components/footer-component/footer.component";
import {LoginComponent} from "./modules/header/components/login-component/login.component";
import {RegistrationComponent} from "./modules/header/components/registration-component/registration.component";
import {TopComponent} from "./modules/header/components/top-component/top.component";
import {CategoryComponent} from "./modules/header/components/category-coponent/category.component";
import {AddComponent} from "./modules/header/components/add-product/add.component";
import {MyProductComponent} from "./modules/header/components/my-product/my-product.component";
import {BlockCustomerComponent} from "./modules/header/components/block-customer/block-customer.component";
import {BlockAdvertiserComponent} from "./modules/header/components/block-advertiser/block-advertiser.component";
import {ProductConfirmComponent} from "./modules/header/components/product-confirm/product-confirm.component";
import {ProductDeleteComponent} from "./modules/header/components/product-delete/product-delete.component";
import {WalletComponent} from "./modules/header/components/wallet-component/wallet.component";

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'catalog', component: CatalogComponent},
  {path: 'subscription', component: SubscriptionComponent},
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'top', component: TopComponent},
  {path: 'category', component: CategoryComponent},
  {path: 'add', component: AddComponent},
  {path: 'myProduct', component: MyProductComponent},
  {path: 'blockCustomer', component: BlockCustomerComponent},
  {path: 'blockAdvertiser', component: BlockAdvertiserComponent},
  {path: 'productConfirm', component: ProductConfirmComponent},
  {path: 'productDelete', component: ProductDeleteComponent},
  {path: 'wallet', component: WalletComponent},
  ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CatalogComponent,
    SubscriptionComponent,
    HeaderGuestComponent,
    HeaderUserComponent,
    HeaderAdvertiserComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    TopComponent,
    CategoryComponent,
    AddComponent,
    MyProductComponent,
    BlockCustomerComponent,
    BlockAdvertiserComponent,
    ProductConfirmComponent,
    ProductDeleteComponent,
    WalletComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],

  bootstrap: [AppComponent],
  exports: [],
  providers: []
})

export class AppModule {
}
