package pricing;

public class VoucherPricingRuleOne implements PricingRule {

  private static final double PRICE_DISCOUNT = 5.00;

  private static final Integer ITEMS_AMOUNT = 2;

  @Override
  public double applyDiscount(double productPrice, Long itemAmount) {
    double price;
    if (itemAmount < ITEMS_AMOUNT) {
      price = productPrice * itemAmount;
    } else {
      var resto = itemAmount % 2;
      var count = itemAmount / 2;
      if (resto == 0) {
        price = count * PRICE_DISCOUNT;
      } else {
        price = count * PRICE_DISCOUNT + productPrice;
      }
    }
    return price;
  }
}
