package pricing;

import product.Product;
import product.ProductType;;

public class PantsPricingRule extends PricingRule {

  PricingRuleFactory pricingRuleFactory;

  public PantsPricingRule(ProductType productType,PricingRuleFactory pricingRuleFactory) {
    this.pricingRuleFactory = pricingRuleFactory;
    super.productType = productType;
  }

  @Override
  public double applyDiscount(Product product, int size) {
    return pricingRuleFactory.getDiscount(product,size);
  }
}
