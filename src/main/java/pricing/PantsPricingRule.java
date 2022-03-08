package pricing;

import product.ProductType;

public class PantsPricingRule extends PricingRule {

  public static final double PRICE = 7.50;

  public PantsPricingRule(ProductType type) {
    super(type);
  }

  @Override
  public double applyDiscount(double price, Long size) {
    return PRICE * size;
  }
}
