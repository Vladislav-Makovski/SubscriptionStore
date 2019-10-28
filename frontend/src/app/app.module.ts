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

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'catalog', component: CatalogComponent},
  {path: 'subscription', component: SubscriptionComponent},
  {path: '', component: HomeComponent},
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
