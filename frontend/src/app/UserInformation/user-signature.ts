export class UserSignature {

  id: string;
  userRole: string;
  userDetailsId: string;
  walletId: string;

  static cloneBase(userSignature: UserSignature): UserSignature {
    const clonedUserSignature: UserSignature = new UserSignature();
    clonedUserSignature.id = userSignature.id;
    clonedUserSignature.userDetailsId = userSignature.userDetailsId;
    clonedUserSignature.userRole = userSignature.userRole;
    clonedUserSignature.walletId = userSignature.walletId;
    return clonedUserSignature;
  }

}
