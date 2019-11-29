export class CustomerSubscription {
  id: string;
  name: string;
  category: string;
  cost: string;

  static cloneBase(customerSubscription: CustomerSubscription): CustomerSubscription {
    const clonedCustomerSubscription: CustomerSubscription = new CustomerSubscription();
    clonedCustomerSubscription.id = customerSubscription.id;
    clonedCustomerSubscription.name = customerSubscription.name;
    clonedCustomerSubscription.category = customerSubscription.category;
    clonedCustomerSubscription.cost = customerSubscription.cost;
    return clonedCustomerSubscription;
  }
}

export class CustomerSubscriptionStr {
}
