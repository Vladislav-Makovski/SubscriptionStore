export class AddProductModel{
  name: string;
  description: string;
  categoryId: string;
  cost: string;
  subscriptionCount: string;
  statusProductId: string;
  organizationId: string;

  static cloneBase(prod: AddProductModel): AddProductModel {
    const clonedProduct: AddProductModel = new AddProductModel();
    clonedProduct.name = prod.name;
    clonedProduct.description = prod.description;
    clonedProduct.categoryId = prod.categoryId;
    clonedProduct.cost = prod.cost;
    clonedProduct.subscriptionCount = prod.subscriptionCount;
    clonedProduct.statusProductId = prod.statusProductId;
    clonedProduct.organizationId = prod.organizationId;
    return clonedProduct;
  }
}

export class AddProductModelStr {
}
