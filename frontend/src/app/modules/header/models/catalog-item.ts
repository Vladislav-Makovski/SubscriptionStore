export class CatalogItem {
  id: string;
  name: string;
  description: string;
  categoryId: string;
  cost: string;
  subscriptionCount: string;

  static cloneBase(catalogItem: CatalogItem): CatalogItem {
    const clonedCatalogItem: CatalogItem = new CatalogItem();
    clonedCatalogItem.id = catalogItem.id;
    clonedCatalogItem.name = catalogItem.name;
    clonedCatalogItem.description = catalogItem.description;
    clonedCatalogItem.categoryId = catalogItem.categoryId;
    clonedCatalogItem.cost = catalogItem.cost;
    clonedCatalogItem.subscriptionCount = catalogItem.subscriptionCount;
    return clonedCatalogItem;
  }
}

export class CatalogItemStr {
}
