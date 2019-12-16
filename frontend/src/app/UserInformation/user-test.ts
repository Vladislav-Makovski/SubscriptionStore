export class UserTest {
  jwttoken: string;
  id: string;
  userDetailsId: string;
  walletId: string;
  userRole: string;

  static cloneBase(userTest: UserTest): UserTest {
    const clonedUserTest: UserTest = new UserTest();
    clonedUserTest.id = userTest.id;
    clonedUserTest.userDetailsId = userTest.userDetailsId;
    clonedUserTest.walletId = userTest.walletId;
    clonedUserTest.userRole = userTest.userRole;
    clonedUserTest.jwttoken = userTest.jwttoken;
    return clonedUserTest;
  }

}
