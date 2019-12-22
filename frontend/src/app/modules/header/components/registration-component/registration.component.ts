import {Component, ElementRef, EmbeddedViewRef, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Subscription} from "rxjs/index";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {RegistrationService} from "../../../../services/registration.service";
import {UserSignature} from "../../../../UserInformation/user-signature";
import {RegistrationCustomer} from "../../models/registration-customer";
import {RegistrationAdvertiser} from "../../models/registration-advertiser";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Router} from "@angular/router";

@Component({
  selector: 'my-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  @ViewChild('registrationSuccessful')
  private registrationSuccessful: ElementRef;

  myFormUser: FormGroup;
  public modalRef: BsModalRef;
  public userRegistrationTypes = ["Customer", "Advertiser"];
  public user: UserSignature = new UserSignature();
  public currentRegistrationType: string = this.userRegistrationTypes[0];
  public customerInformation: RegistrationCustomer = new RegistrationCustomer();
  public advertiserInformation: RegistrationAdvertiser = new RegistrationAdvertiser();
  private subscriptions: Subscription[] = [];
  public errorRegistration: boolean = false;

  constructor(private registrationService: RegistrationService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService,
              private  router : Router) {
  }


  ngOnInit() {
    this.myFormUser = new FormGroup({
      "email": new FormControl("", [Validators.required, Validators.email,Validators.pattern(/^\S*$/)]),
      "password": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "nickname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "name": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "surname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
    });
  }

  submitUser():void {
    if(this.currentRegistrationType == this.userRegistrationTypes[0]){
      this.customerInformation.username = this.myFormUser.controls['nickname'].value;
      this.customerInformation.password = this.myFormUser.controls['password'].value;
      this.customerInformation.email = this.myFormUser.controls['email'].value;
      this.customerInformation.userRoleId = "1";
      this.customerInformation.firstName = this.myFormUser.controls['name'].value;
      this.customerInformation.surname = this.myFormUser.controls['surname'].value;
      this.customerInformation.balance = "0";
      this.customerInformation.statusWalletId = "1";
      this.loadingService.show();
      this.subscriptions.push(this.registrationService.saveNewCustomer(this.customerInformation).subscribe(accounts => {
        this.user = accounts as UserSignature ;
        if(this.user.id !== "0"){
          this.router.navigate(['/login']);
        }else{
          this.errorRegistration = true;
        }
        this.loadingService.hide();
      }));
    }else{
      this.advertiserInformation.username = this.myFormUser.controls['nickname'].value;
      this.advertiserInformation.password = this.myFormUser.controls['password'].value;
      this.advertiserInformation.email = this.myFormUser.controls['email'].value;
      this.advertiserInformation.userRoleId = "2";
      this.advertiserInformation.name = this.myFormUser.controls['name'].value;
      this.advertiserInformation.balance = "0";
      this.advertiserInformation.statusWalletId = "1";
      this.subscriptions.push(this.registrationService.saveNewAdvertiser(this.advertiserInformation).subscribe(accounts => {
        this.user = accounts as UserSignature ;
        if(this.user.id !== '0'){
          this.router.navigate(['/login']);
        }else{
          this.errorRegistration = true;
        }
        this.loadingService.hide();
      }));
    }
  }

  onChange(value: string) {
    this.currentRegistrationType = value;
    if(this.currentRegistrationType == 'Advertiser'){
      this.myFormUser = new FormGroup({
        "email": new FormControl("", [Validators.required, Validators.email,Validators.pattern(/^\S*$/)]),
        "password": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
        "nickname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
        "name": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      });
    }else{
      this.myFormUser = new FormGroup({
        "email": new FormControl("", [Validators.required, Validators.email,Validators.pattern(/^\S*$/)]),
        "password": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
        "nickname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
        "name": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
        "surname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      });
    }
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  submitReg():void{
    this.myFormUser = new FormGroup({
      "email": new FormControl("", [Validators.required, Validators.email,Validators.pattern(/^\S*$/)]),
      "password": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "nickname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "name": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
      "surname": new FormControl("", [Validators.required,Validators.pattern(/^\S*$/)]),
    });
    this.errorRegistration = false;

  }
  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
  navig():void{
    window.scroll(0,0);
  }

}
