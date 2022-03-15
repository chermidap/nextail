package pricing;

import product.Product;

public interface PricingRuleFactory {

  double getDiscount(Product product, int size);

}
