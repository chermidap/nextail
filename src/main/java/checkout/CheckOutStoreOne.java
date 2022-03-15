package checkout;

import static product.ProductType.DEFAULT;

import java.util.List;
import pricing.DefaultPricingNoDiscountRule;
import pricing.DefaultPricingRule;
import pricing.PricingRule;

public class CheckOutStoreOne extends CheckOut {

  public CheckOutStoreOne(List<PricingRule> pricingRuleList) {
    super(pricingRuleList);
  }

  @Override
  public PricingRule getPricingRule(String itemType) {

    return pricingRuleList.stream()
        .filter(pricingRule -> pricingRule.productType.name().equals(itemType))
        .findFirst().orElseGet(() -> new DefaultPricingRule(new DefaultPricingNoDiscountRule()));
  }
}
