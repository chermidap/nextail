package pricing;

import product.Product;

public class PantsPricingRuleTwo implements PricingRuleFactory {

  private static final double DISCOUNT_PRICE = 7.00;

  private static final Integer ITEMS_AMOUNT = 3;

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
