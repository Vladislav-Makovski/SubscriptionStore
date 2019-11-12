import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector :'my-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit{

  myFormUser : FormGroup;

  constructor(){
    this.myFormUser = new FormGroup({

      "email": new FormControl("", [Validators.required,Validators.email]),
      "password": new FormControl("", Validators.required),
      "nickname": new FormControl("", Validators.required),
      "name": new FormControl("", Validators.required),
      "surname": new FormControl("", Validators.required),
    });
  }
  ngOnInit(){}

  submitUser(){
    console.log(this.myFormUser);
  }
}
