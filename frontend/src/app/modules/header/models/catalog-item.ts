export class CatalogItem {
  id: string;
  name: string;
  description: string;
  category: string;
  cost: string;

  static cloneBase(catalogItem: CatalogItem): CatalogItem {
    const clonedCatalogItem: CatalogItem = new CatalogItem();
    clonedCatalogItem.id = catalogItem.id;
    clonedCatalogItem.name = catalogItem.name;
    clonedCatalogItem.description = catalogItem.description;
    clonedCatalogItem.category = catalogItem.category;
    clonedCatalogItem.cost = catalogItem.cost;
    return clonedCatalogItem;
  }
}

export class CatalogItemStr {
}
