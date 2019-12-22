export class BooModel {
  cond: string;
  static cloneBase(boo: BooModel): BooModel {
    const clonedAdvertiser: BooModel = new BooModel();
    clonedAdvertiser.cond = boo.cond;
    return clonedAdvertiser;
  }
}
