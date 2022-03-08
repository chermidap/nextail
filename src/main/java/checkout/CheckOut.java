package checkout;

import pricing.PricingRule;
import product.Product;

public abstract class CheckOut {

  public PricingRule scan(Product item) {
    PricingRule pricingRule = null;
    if(item!=null){
      pricingRule = getPricingRule(item.getCode());
    }
    return pricingRule;
  }

  protected abstract PricingRule getPricingRule(String itemType);
}
