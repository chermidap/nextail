package pricing;

import product.ProductType;

public abstract class PricingRule {

  private ProductType type;

  protected PricingRule(ProductType type) {
    this.type = type;
  }

  public abstract double applyDiscount(double price, Long itemAmount);

  public ProductType getType() {
    return type;
  }
}
