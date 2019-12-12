export class UserTest {
  jwttoken: string;
  id: string;
  username: string;
  email: string;
  userRoleId: string;

  static cloneBase(userTest: UserTest): UserTest {
    const clonedUserTest: UserTest = new UserTest();
    clonedUserTest.id = userTest.id;
    clonedUserTest.username = userTest.username;
    clonedUserTest.email = userTest.email;
    clonedUserTest.userRoleId = userTest.userRoleId;
    clonedUserTest.jwttoken = userTest.jwttoken;
    return clonedUserTest;
  }

}
