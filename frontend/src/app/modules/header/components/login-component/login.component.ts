import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import {Subscription} from "rxjs/index";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserLogin} from "../../models/UserLogin";
import {UserTest} from "../../../../UserInformation/user-test";
import {LoginService} from "../../../../services/LoginService";

@Component({
  selector :'my-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{
  loginUser: UserLogin = new UserLogin();
  userTest: UserTest = new UserTest();
  myForm : FormGroup;
  private subscriptions: Subscription[] = [];

  constructor(private loginService: LoginService,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  ngOnInit(){
    this.myForm = new FormGroup({
      "username": new FormControl("", Validators.required),
      "password": new FormControl("", Validators.required),
    });
  }

  submit(){
      this.loginUser.username = this.myForm.controls['username'].value;

      this.loginUser.password = this.myForm.controls['password'].value;
      this.loadingService.show();
      this.subscriptions.push(this.loginService.loginUser(this.loginUser).subscribe(accounts => {
        this.userTest = accounts as UserTest ;
        console.log(this.userTest);
        this.loadingService.hide();
      }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
