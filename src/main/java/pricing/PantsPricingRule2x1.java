package pricing;

import product.Product;

public class PantsPricingRule2x1 implements PricingRuleFactory{
  private static final double DISCOUNT_PRICE = 6.00;

  private static final Integer ITEMS_AMOUNT = 2;

  @Override
  public double getDiscount(Product product, int size) {
    double price;
    if(size > ITEMS_AMOUNT){
      price = DISCOUNT_PRICE * size;
    }else{
      price =  product.getPrice() * size;
    }
    return price;
  }
}
