export class Category {
  id: string;
  name: string;


  static cloneBase(category: Category): Category {
    const clonedCategory: Category = new Category();
    clonedCategory.id = category.id;
    clonedCategory.name = category.name;
    return clonedCategory;
  }
}

export class CatalogItemStr {
}
