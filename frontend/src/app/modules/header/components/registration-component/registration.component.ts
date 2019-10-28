import {Component, OnInit} from '@angular/core';

@Component({
  selector :'my-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit{

  userBoolean: boolean;
  advertiserBoolean: boolean;
  constructor(){}
  ngOnInit(){
    this.userBoolean = false;
    this.advertiserBoolean = false;
  }
  userForm(){
    this.advertiserBoolean = false;
    this.userBoolean = !this.userBoolean;
  }
  advertiserForm(){
    this.userBoolean = false;
    this.advertiserBoolean = !this.advertiserBoolean;
  }
}
