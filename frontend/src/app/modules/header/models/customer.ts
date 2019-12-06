export class Customer{
  id: string;
  firstName: string;
  surname: string;
  walletId :string;
  userDetailsId: string;
  balance: string;

  static cloneBase(customer: Customer): Customer {
    const clonedCustomer: Customer = new Customer();
    clonedCustomer.id = customer.id;
    clonedCustomer.firstName = customer.firstName;
    clonedCustomer.surname = customer.surname;
    clonedCustomer.walletId = customer.walletId;
    clonedCustomer.userDetailsId = customer.userDetailsId;
    clonedCustomer.balance = customer.balance;

    return clonedCustomer;
  }
}

export class CustomerStr {
}
