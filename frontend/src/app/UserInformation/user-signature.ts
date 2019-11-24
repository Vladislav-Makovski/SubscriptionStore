export class UserSignature {

  id: string;
  username: string;
  password: string;
  email: string;
  userRole: string;
  userDetailsId: string;
  firstName: string;
  surName:string;
  walletId:string;

  constructor(){
    this.id = "2";
    this.username ="katya";
    this.password = "3333";
    this.email = "katya@mail.ru";
    this.userRole = "customer";
    this.userDetailsId = "3";
    this.firstName = "katya";
    this.surName = "valiok";
    this.walletId = "2";
  }

  getInfo(): string {
    return "id:" + this.id + " username:" + this.username + " userRole:" + this.userRole;
  }
}
