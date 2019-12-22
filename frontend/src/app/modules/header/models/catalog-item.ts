export class CatalogItem {
  id: string;
  name: string;
  description: string;
  category: string;
  cost: string;
  subscriptionCount: string;
  cond:string;

  static cloneBase(catalogItem: CatalogItem): CatalogItem {
    const clonedCatalogItem: CatalogItem = new CatalogItem();
    clonedCatalogItem.id = catalogItem.id;
    clonedCatalogItem.name = catalogItem.name;
    clonedCatalogItem.description = catalogItem.description;
    clonedCatalogItem.category = catalogItem.category;
    clonedCatalogItem.cost = catalogItem.cost;
    clonedCatalogItem.subscriptionCount = catalogItem.subscriptionCount;
    clonedCatalogItem.cond = catalogItem.cond;
    return clonedCatalogItem;
  }
}

export class CatalogItemStr {
}
