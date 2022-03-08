package checkout;

import static product.ProductType.DEFAULT;

import java.util.List;
import pricing.DefaultPricingRule;
import pricing.PricingRule;

public class CheckOutStoreTwo extends CheckOut {

  public CheckOutStoreTwo(List<PricingRule> pricingRuleList) {
    super(pricingRuleList);
  }

  @Override
  public PricingRule getPricingRule(String itemType) {
    if (pricingRuleList.isEmpty()) {
      return new DefaultPricingRule(DEFAULT);
    } else {
      return pricingRuleList.stream()
          .filter(pricingRule -> pricingRule.getType().name().equals(itemType))
          .findFirst().orElseGet(() -> new DefaultPricingRule(DEFAULT));
    }
  }
}
