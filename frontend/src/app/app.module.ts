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

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'catalog', component: CatalogComponent},
  {path: 'subscription', component: SubscriptionComponent},
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
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
