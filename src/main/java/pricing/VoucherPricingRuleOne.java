package pricing;

import product.Product;

public class VoucherPricingRuleOne implements PricingRuleFactory {

  private static final double PRICE_DISCOUNT = 5.00;

  private static final Integer ITEMS_AMOUNT = 2;

  @Override
  public double getDiscount(Product product, int itemAmount) {
    double price;
    if (itemAmount < ITEMS_AMOUNT) {
      price = product.getPrice() * itemAmount;
    } else {
      var resto = itemAmount % 2;
      var count = itemAmount / 2;
      if (resto == 0) {
        price = count * PRICE_DISCOUNT;
      } else {
        price = count * PRICE_DISCOUNT + product.getPrice();
      }
    }
    return price;
  }
}
