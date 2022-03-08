package pricing;

import product.ProductType;

public class TshirtPricingRule extends PricingRule {

  private static final double DISCOUNT_PRICE = 19.00;

  private static final Integer ITEMS_AMOUNT = 2;

  public TshirtPricingRule(ProductType type) {
    super(type);
  }

  @Override
  public double applyDiscount(double productPrice,Long size) {
    double price;
    if(size > ITEMS_AMOUNT){
      price = DISCOUNT_PRICE * size;
    }else{
      price =  productPrice * size;
    }
    return price;
  }
}
