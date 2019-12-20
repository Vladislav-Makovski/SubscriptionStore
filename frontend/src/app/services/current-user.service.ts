import {UserTest} from "../UserInformation/user-test";
import {UserSignature} from "../UserInformation/user-signature";

export class CurrentUserService{
  public _currentUser: UserSignature = new UserSignature();

  constructor() {
    this._currentUser.userRole="guest";
  }

   saveCurrentUser(newUser: UserSignature):void{
     this._currentUser = newUser;
    }

}
