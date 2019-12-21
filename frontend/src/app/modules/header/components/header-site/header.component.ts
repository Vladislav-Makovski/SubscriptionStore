import {Component, OnInit} from '@angular/core';
import {CurrentUserService} from "../../../../services/current-user.service";

@Component({
  selector :'header-site',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  lod:boolean = true;
  constructor(private currentUser: CurrentUserService) {}

  ngOnInit(){
    if(localStorage.getItem("token")!== null){
      this.lod = false;
    }
  }
  logout():void{
    localStorage.clear();
    this.lod = true;
  }
}
