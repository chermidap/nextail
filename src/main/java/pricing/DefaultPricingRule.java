package pricing;

import product.ProductType;

public class DefaultPricingRule extends PricingRule{

  public DefaultPricingRule(ProductType type) {
    super(type);
  }

  @Override
  public double applyDiscount(double price, Long itemAmount) {
    return price * itemAmount;
  }
}
