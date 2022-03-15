package pricing;

import product.Product;

public class DefaultPricingRule extends PricingRule {

  PricingRuleFactory pricingRuleFactory;

  public DefaultPricingRule(PricingRuleFactory pricingRuleFactory) {
    this.pricingRuleFactory = pricingRuleFactory;
  }

  @Override
  public double applyDiscount(Product product, int itemAmount) {
   return pricingRuleFactory.getDiscount(product,itemAmount);
  }
}
