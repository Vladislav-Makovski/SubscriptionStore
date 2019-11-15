import {Component, OnInit} from '@angular/core';

@Component({
  selector :'header-site',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  user: string;


  constructor(){}
  ngOnInit(){
    this.user = "guest";
  }
}
