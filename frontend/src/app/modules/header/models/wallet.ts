export class Wallet {
  id: string;
  balance: string;
  status: string;


  static cloneBase(wallet: Wallet): Wallet {
    const clonedWallet: Wallet = new Wallet();
    clonedWallet.id = wallet.id;
    clonedWallet.balance = wallet.balance;
    clonedWallet.status = wallet.status;
    return clonedWallet;
  }
}

export class WalletStr {
}
