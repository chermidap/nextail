package checkout;

import pricing.DefaultPricingRule;
import pricing.PantsPricingRule;
import pricing.PricingRule;
import pricing.TshirtPricingRule;
import pricing.VoucherPricingRuleOne;
import product.ProductType;

public class CheckOutStoreOne extends CheckOut{

  @Override
  public PricingRule getPricingRule(String itemType) {
    if (itemType.equals(ProductType.VOUCHER.name())) {
      return new VoucherPricingRuleOne();
    } else if (itemType.equals(ProductType.TSHIRT.name())) {
      return new TshirtPricingRule();
    } else if (itemType.equals(ProductType.PANTS.name())) {
      return new PantsPricingRule();
    }else return new DefaultPricingRule();
  }
}
