package checkout;

import pricing.DefaultPricingRule;
import pricing.PantsPricingRuleTwo;
import pricing.PricingRule;
import pricing.TshirtPricingRule;
import pricing.VoucherPricingRuleTwo;
import product.ProductType;

public class CheckOutStoreTwo extends CheckOut{

  @Override
  public PricingRule getPricingRule(String itemType) {
    if (itemType.equals(ProductType.VOUCHER.name())) {
      return new VoucherPricingRuleTwo();
    } else if (itemType.equals(ProductType.TSHIRT.name())) {
      return new TshirtPricingRule();
    } else if (itemType.equals(ProductType.PANTS.name())) {
      return new PantsPricingRuleTwo();
    }else return new DefaultPricingRule();
  }
}
