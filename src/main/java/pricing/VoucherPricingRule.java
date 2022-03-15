package pricing;

import product.Product;
import product.ProductType;

public class VoucherPricingRule extends PricingRule {

  PricingRuleFactory pricingRuleFactory;

  public VoucherPricingRule(ProductType productType,PricingRuleFactory pricingRuleFactory) {
    this.pricingRuleFactory = pricingRuleFactory;
    super.productType = productType;
  }

  @Override
  public double applyDiscount(Product product, int size) {
    return pricingRuleFactory.getDiscount(product,size);
  }
}
