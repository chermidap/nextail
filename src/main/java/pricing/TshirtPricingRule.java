package pricing;

import product.Product;
import product.ProductType;

public class TshirtPricingRule extends PricingRule {

  PricingRuleFactory pricingRuleFactory;

  public TshirtPricingRule(ProductType productType,PricingRuleFactory pricingRuleFactory) {
    this.pricingRuleFactory = pricingRuleFactory;
    super.productType = productType;
  }

  @Override
  public double applyDiscount(Product product, int itemAmount) {
    return pricingRuleFactory.getDiscount(product,itemAmount);
  }
}
