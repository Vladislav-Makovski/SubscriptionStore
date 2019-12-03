export class RegistrationModel{
  username: string;
  password: string;
  email: string;
  userRoleId: string;
  firstName: string;
  surname: string;
  balance: string;
  statusWalletId: string;

  static cloneBase(registrationModel: RegistrationModel): RegistrationModel {
    const clonedRegistrationModel: RegistrationModel = new RegistrationModel();
    clonedRegistrationModel.username = registrationModel.username;
    clonedRegistrationModel.password = registrationModel.password;
    clonedRegistrationModel.email = registrationModel.email;
    clonedRegistrationModel.userRoleId = registrationModel.userRoleId;
    clonedRegistrationModel.firstName = registrationModel.firstName;
    clonedRegistrationModel.surname = registrationModel.surname;
    clonedRegistrationModel.balance = registrationModel.balance;
    clonedRegistrationModel.statusWalletId = registrationModel.statusWalletId;
    return clonedRegistrationModel;
  }
}
export class RegistrationModelStr {
}
