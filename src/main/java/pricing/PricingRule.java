package pricing;

import product.Product;
import product.ProductType;

public abstract class PricingRule {

  public ProductType productType;

  public abstract double applyDiscount(Product product, int itemAmount);

}
