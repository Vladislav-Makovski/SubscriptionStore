export class UserLogin{
  username: string;
  password: string;

  static cloneBase(userLogin: UserLogin): UserLogin {
    const clonedUserLogin: UserLogin = new UserLogin();
    clonedUserLogin.username = userLogin.username;
    clonedUserLogin.password = userLogin.password;

    return clonedUserLogin;
  }
}
