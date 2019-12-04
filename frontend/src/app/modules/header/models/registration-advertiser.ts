export class RegistrationAdvertiser{
  username: string;
  password: string;
  email: string;
  userRoleId: string;
  name: string;
  balance: string;
  statusWalletId: string;

  static cloneBase(registrationAdvertiser: RegistrationAdvertiser): RegistrationAdvertiser {
    const clonedRegistrationAdvertiser: RegistrationAdvertiser = new RegistrationAdvertiser();
    clonedRegistrationAdvertiser.username = registrationAdvertiser.username;
    clonedRegistrationAdvertiser.password = registrationAdvertiser.password;
    clonedRegistrationAdvertiser.email = registrationAdvertiser.email;
    clonedRegistrationAdvertiser.name = registrationAdvertiser.name;
    clonedRegistrationAdvertiser.userRoleId = registrationAdvertiser.userRoleId;
    clonedRegistrationAdvertiser.balance = registrationAdvertiser.balance;
    clonedRegistrationAdvertiser.statusWalletId = registrationAdvertiser.statusWalletId;
    return clonedRegistrationAdvertiser;
  }
}

export class RegistrationAdvertiserStr {
}
