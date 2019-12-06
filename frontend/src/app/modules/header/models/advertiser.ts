export class Advertiser {
  id: string;
  name: string;
  walletId: string;
  userDetailsId: string;
  balance: string;


  static cloneBase(advertiser: Advertiser): Advertiser {
    const clonedAdvertiser: Advertiser = new Advertiser();
    clonedAdvertiser.id = advertiser.id;
    clonedAdvertiser.name = advertiser.name;
    clonedAdvertiser.walletId = advertiser.walletId;
    clonedAdvertiser.userDetailsId = advertiser.userDetailsId;
    clonedAdvertiser.balance = advertiser.balance;

    return clonedAdvertiser;
  }
}

export class AdvertiserStr {
}
