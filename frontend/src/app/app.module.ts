import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {HomeComponent} from "./modules/header/components/home-component/home.component";
import {CatalogComponent} from "./modules/header/components/catalog-component/catalog.component";
import {SubscriptionComponent} from "./modules/header/components/subscription-component/subscription.component";
import {FooterComponent} from "./modules/header/components/footer-component/footer.component";
import {LoginComponent} from "./modules/header/components/login-component/login.component";
import {RegistrationComponent} from "./modules/header/components/registration-component/registration.component";
import {TopComponent} from "./modules/header/components/top-component/top.component";
import {AddComponent} from "./modules/header/components/add-product/add.component";
import {MyProductComponent} from "./modules/header/components/my-product/my-product.component";
import {BlockCustomerComponent} from "./modules/header/components/block-customer/block-customer.component";
import {BlockAdvertiserComponent} from "./modules/header/components/block-advertiser/block-advertiser.component";
import {ProductConfirmComponent} from "./modules/header/components/product-confirm/product-confirm.component";
import {ProductDeleteComponent} from "./modules/header/components/product-delete/product-delete.component";
import {WalletComponent} from "./modules/header/components/wallet-component/wallet.component";
import {HeaderComponent} from "./modules/header/components/header-site/header.component";
import {CatalogService} from "./services/catalog.service";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule, HttpHeaders} from "@angular/common/http";
import {BsModalService, ModalModule} from "ngx-bootstrap";
import {CategoryService} from "./services/category.service";
import {WalletService} from "./services/wallet.service";
import {CustomerSubscriptionService} from "./services/customerSubscription.service";
import {RegistrationService} from "./services/registration.service";
import {AddProductService} from "./services/add-product.service";
import {AdvertiserService} from "./services/advertiser.service";
import {CustomerService} from "./services/customer.service";
import {LoginService} from "./services/LoginService";
import {ProductService} from "./services/product.service";
import {SubscribeService} from "./services/subscribe.service";
import {CurrentUserService} from "./services/current-user.service";
import {AuthInterceptor} from "./services/AuthInterceptor";

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'catalog', component: CatalogComponent},
  {path: 'subscription', component: SubscriptionComponent},
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'top', component: TopComponent},
  {path: 'add', component: AddComponent},
  {path: 'myProduct', component: MyProductComponent},
  {path: 'blockCustomer', component: BlockCustomerComponent},
  {path: 'blockAdvertiser', component: BlockAdvertiserComponent},
  {path: 'productConfirm', component: ProductConfirmComponent},
  {path: 'productDelete', component: ProductDeleteComponent},
  {path: 'wallet', component: WalletComponent},
];

export function loadFromToken(http: HttpClient, currentUser: CurrentUserService){
  return () => {
    console.log('init');
    if(localStorage.getItem('token')!=null){
      return http.get<any>('/api/oninit/'+localStorage.getItem('token'))
        .toPromise()
        .then((resp) =>{
          currentUser._currentUser = resp;
          console.log(resp);
        });
    }
  }
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CatalogComponent,
    SubscriptionComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    TopComponent,
    AddComponent,
    MyProductComponent,
    BlockCustomerComponent,
    BlockAdvertiserComponent,
    ProductConfirmComponent,
    ProductDeleteComponent,
    WalletComponent,
    HeaderComponent,
  ],

  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    ModalModule.forRoot(),
    Ng4LoadingSpinnerModule.forRoot(),
    HttpClientModule,
  ],
  bootstrap: [AppComponent],
  exports: [],
  providers: [CatalogService,CategoryService,HttpClient,BsModalService,WalletService,CustomerSubscriptionService,
    RegistrationService,AddProductService,AdvertiserService,CustomerService,LoginService,ProductService,
    SubscribeService,CurrentUserService,{
    provide: APP_INITIALIZER,
      useFactory: loadFromToken,
      multi: true,
      deps: [HttpClient,CurrentUserService]
    },
    {
    provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
  }]
})

export class AppModule {
}


