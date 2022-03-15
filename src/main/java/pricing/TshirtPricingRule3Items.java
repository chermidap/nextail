package pricing;

import product.Product;

public class TshirtPricingRule3Items implements PricingRuleFactory{

  private static final double DISCOUNT_PRICE = 19.00;

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
