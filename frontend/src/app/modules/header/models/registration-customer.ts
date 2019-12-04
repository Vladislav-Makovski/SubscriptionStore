export class RegistrationCustomer{
  username: string;
  password: string;
  email: string;
  userRoleId: string;
  firstName: string;
  surname: string;
  balance: string;
  statusWalletId: string;

  static cloneBase(registrationCustomer: RegistrationCustomer): RegistrationCustomer {
    const clonedRegistrationCustomer: RegistrationCustomer = new RegistrationCustomer();
    clonedRegistrationCustomer.username = registrationCustomer.username;
    clonedRegistrationCustomer.password = registrationCustomer.password;
    clonedRegistrationCustomer.email = registrationCustomer.email;
    clonedRegistrationCustomer.userRoleId = registrationCustomer.userRoleId;
    clonedRegistrationCustomer.firstName = registrationCustomer.firstName;
    clonedRegistrationCustomer.surname = registrationCustomer.surname;
    clonedRegistrationCustomer.balance = registrationCustomer.balance;
    clonedRegistrationCustomer.statusWalletId = registrationCustomer.statusWalletId;
    return clonedRegistrationCustomer;
  }
}

export class RegistrationCustomerStr {
}
