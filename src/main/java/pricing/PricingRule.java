package pricing;

public interface PricingRule {
  double applyDiscount(double price,Long itemAmount);
}
