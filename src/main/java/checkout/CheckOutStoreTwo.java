package checkout;

import java.util.List;
import pricing.DefaultPricingNoDiscountRule;
import pricing.DefaultPricingRule;
import pricing.PricingRule;

public class CheckOutStoreTwo extends CheckOut {

  public CheckOutStoreTwo(List<PricingRule> pricingRuleList) {
    super(pricingRuleList);
  }

  @Override
  public PricingRule getPricingRule(String itemType) {
    if (pricingRuleList.isEmpty()) {
      return new DefaultPricingRule(new DefaultPricingNoDiscountRule());
    } else {
      return pricingRuleList.stream()
          .filter(pricingRule -> pricingRule.productType.name().equals(itemType))
          .findFirst().orElseGet(() -> new DefaultPricingRule(new DefaultPricingNoDiscountRule()));
    }
  }
}
