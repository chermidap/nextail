package checkout;

import static product.ProductType.DEFAULT;

import java.util.List;
import pricing.DefaultPricingRule;
import pricing.PricingRule;

public class CheckOutStoreOne extends CheckOut {

  public CheckOutStoreOne(List<PricingRule> pricingRuleList) {
    super(pricingRuleList);
  }

  @Override
  public PricingRule getPricingRule(String itemType) {
    return pricingRuleList.stream()
        .filter(pricingRule -> pricingRule.getType().name().equals(itemType))
        .findFirst().orElseGet(() -> new DefaultPricingRule(DEFAULT));
  }
}
