package pricing;

public class VoucherPricingRuleTwo implements PricingRule{

  private static final double PRICE_DISCOUNT = 4.00;

  private static final Integer ITEMS_AMOUNT = 5;

  @Override
  public double applyDiscount(double productPrice, Long itemAmount) {
    double price;
    if (itemAmount < ITEMS_AMOUNT) {
      price = productPrice;
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
