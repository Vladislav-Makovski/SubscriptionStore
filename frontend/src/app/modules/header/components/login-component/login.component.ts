import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import {Subscription} from "rxjs/index";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserLogin} from "../../models/UserLogin";
import {UserTest} from "../../../../UserInformation/user-test";
import {LoginService} from "../../../../services/LoginService";
import {CurrentUserService} from "../../../../services/current-user.service";
import {Router} from "@angular/router";

@Component({
  selector :'my-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})

export class LoginComponent implements OnInit{
  loginUser: UserLogin = new UserLogin();
  userTest: UserTest = new UserTest();
  myForm : FormGroup;
  registrationError :boolean = false;
  private subscriptions: Subscription[] = [];
  error:any;

  constructor(private loginService: LoginService,
              private loadingService: Ng4LoadingSpinnerService,
              private currentUser: CurrentUserService,
              private router: Router) {
  }

  ngOnInit(){
    this.registrationError = false;
    this.myForm = new FormGroup({
      "username": new FormControl("", Validators.required),
      "password": new FormControl("", Validators.required),
    });
  }

  submit(){
      this.loginUser.username = this.myForm.controls['username'].value;
    localStorage.clear();
      this.loginUser.password = this.myForm.controls['password'].value;
      this.loadingService.show();
      this.subscriptions.push(this.loginService.loginUser(this.loginUser).subscribe(
        accounts => {
        this.userTest = accounts as UserTest ;
        localStorage.setItem('token', this.userTest.jwttoken);
        console.log(localStorage.getItem("token"));
        delete this.userTest.jwttoken;
        this.currentUser.saveCurrentUser(this.userTest);
        console.log(this.currentUser._currentUser);
        this.router.navigate(['/home']);
        this.loadingService.hide();
      },
        error => this.registrationError = true));
  }

  submitError(): void{
    this.registrationError = false;
    this.myForm =  new FormGroup({
      "username": new FormControl("", Validators.required),
      "password": new FormControl("", Validators.required),
    });
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
