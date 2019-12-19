import {Component, OnInit} from '@angular/core';
import {CurrentUserService} from "../../../../services/current-user.service";

@Component({
  selector :'header-site',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  constructor(private currentUser: CurrentUserService) {}

  ngOnInit(){}

}
