import {Component, OnInit, TemplateRef} from '@angular/core';
import {CatalogItem} from "../../models/catalog-item";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {CatalogService} from "../../../../services/catalog.service";

@Component({
  selector :'Catalog',
  templateUrl: './catalog.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit{

  public editMode = false;
  public catalogItem: CatalogItem[];
  public editableBa: CatalogItem = new CatalogItem();
  public modalRef: BsModalRef;
  private subscriptions: Subscription[] = [];

  constructor(private catalogItemService: CatalogService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) {
    }

  ngOnInit(){
    this.loadCatalogItem();
  }
  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, catalogItem: CatalogItem): void {
    if (catalogItem) {
      this.editMode = true;
      this.editableBa = CatalogItem.cloneBase(catalogItem);
    } else {
      this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  private refreshBa(): void {
    this.editableBa = new CatalogItem();
  }

  private loadCatalogItem(): void {
    this.loadingService.show();
    this.subscriptions.push(this.catalogItemService.getCatalogItem().subscribe(accounts => {
      this.catalogItem = accounts as CatalogItem[];
      console.log(this.catalogItem);
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
