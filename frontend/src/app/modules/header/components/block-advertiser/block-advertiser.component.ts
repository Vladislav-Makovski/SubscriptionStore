import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/index";
import {Advertiser} from "../../models/advertiser";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {AdvertiserService} from "../../../../services/advertiser.service";

@Component({
  selector :'block-advertiser',
  templateUrl: './block-advertiser.component.html',
  styleUrls: ['./block-advertiser.component.css']
})

export class BlockAdvertiserComponent implements OnInit{

  private subscriptions: Subscription[] = [];
  private siteAdvertiser: Advertiser[]= [];

  constructor(private advertiserService: AdvertiserService,
              private loadingService: Ng4LoadingSpinnerService) {
  }
  ngOnInit(){
    this.loadAdvertiser();
  }

  private loadAdvertiser(): void {
    this.loadingService.show();
    this.subscriptions.push(this.advertiserService.getAdvertiserByNameAsc().subscribe(accounts => {
      this.siteAdvertiser = accounts as Advertiser[];
      console.log(this.siteAdvertiser);
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
