import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/index";
import {Customer} from "../../models/customer";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CustomerService} from "../../../../services/customer.service";

@Component({
  selector :'block-customer',
  templateUrl: './block-customer.component.html',
  styleUrls: ['./block-customer.component.css']
})

export class BlockCustomerComponent implements OnInit{
  private subscriptions: Subscription[] = [];
  private siteCustomer: Customer[] = [];

  constructor(private customerService: CustomerService,
              private loadingService: Ng4LoadingSpinnerService) {
  }
  ngOnInit(){
    this.loadCustomer();
  }

  private loadCustomer(): void {
    this.loadingService.show();
    this.subscriptions.push(this.customerService.getCustomerByNameAsc().subscribe(accounts => {
      this.siteCustomer = accounts as Customer[];
      console.log(this.siteCustomer);
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
