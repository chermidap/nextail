package pricing;

public class PantsPricingRule implements PricingRule {

  public static final double PRICE = 7.50;

  @Override
  public double applyDiscount(double price, Long size) {
    return PRICE * size;
  }
}
