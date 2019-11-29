export class WalletUpdate {
  id: string;
  statusWalletId: string;
  balance: number;

  static cloneBase(walletUpdate: WalletUpdate): WalletUpdate {
    const clonedWalletUpdate: WalletUpdate = new WalletUpdate();
    clonedWalletUpdate.id = walletUpdate.id;
    clonedWalletUpdate.balance = walletUpdate.balance;
    clonedWalletUpdate.statusWalletId = walletUpdate.statusWalletId;
    return clonedWalletUpdate;
  }
}

export class WalletUpdateStr {
}
