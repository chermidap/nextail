package checkout;

import java.util.List;
import pricing.PricingRule;
import product.Product;

public abstract class CheckOut {

  List<PricingRule> pricingRuleList;

  protected CheckOut(List<PricingRule> pricingRuleList) {
    this.pricingRuleList = pricingRuleList;
  }

  public PricingRule scan(Product item) {
    PricingRule pricingRule = null;
    if(item!=null){
      pricingRule = getPricingRule(item.getCode());
    }
    return pricingRule;
  }

  public abstract PricingRule getPricingRule(String itemType);
}
