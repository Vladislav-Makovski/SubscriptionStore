export class Product{
  id: string;
  name: string;
  subscriptionCount: string;
  cost: string;
  status: string;
  description: string;
  static cloneBase(product: Product): Product {
    const clonedProduct: Product = new Product();
    clonedProduct.id = product.id;
    clonedProduct.name = product.name;
    clonedProduct.subscriptionCount = product.subscriptionCount;
    clonedProduct.cost = product.cost;
    clonedProduct.status = product.status;
    clonedProduct.description = product.description;
    return clonedProduct;
  }
}

export class ProductStr {
}
