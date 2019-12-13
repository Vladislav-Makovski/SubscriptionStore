export class SubscribeModel{

  userId: string;
  productId: string;
  statusSubId: string;

  static cloneBase(subscribeModel: SubscribeModel): SubscribeModel {
    const clonedSubscribeModel: SubscribeModel = new SubscribeModel();
    clonedSubscribeModel.userId = subscribeModel.userId;
    clonedSubscribeModel.productId = subscribeModel.productId;
    clonedSubscribeModel.statusSubId = subscribeModel.statusSubId;
    return clonedSubscribeModel;
  }
}
