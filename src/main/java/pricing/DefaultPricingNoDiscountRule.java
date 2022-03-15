package pricing;

import product.Product;

public class DefaultPricingNoDiscountRule implements PricingRuleFactory{

  @Override
  public double getDiscount(Product product, int itemAmount) {
    return product.getPrice() * itemAmount;
  }
}
