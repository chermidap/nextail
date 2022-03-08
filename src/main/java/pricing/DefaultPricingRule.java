package pricing;

public class DefaultPricingRule implements PricingRule{

  @Override
  public double applyDiscount(double price, Long itemAmount) {
    return price * itemAmount;
  }
}
