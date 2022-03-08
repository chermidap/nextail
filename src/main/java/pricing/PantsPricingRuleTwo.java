package pricing;

public class PantsPricingRuleTwo implements PricingRule {

  private static final double DISCOUNT_PRICE = 6.00;

  private static final Integer ITEMS_AMOUNT = 2;

  @Override
  public double applyDiscount(double productPrice, Long size) {
    double price;
    if(size > ITEMS_AMOUNT){
      price = DISCOUNT_PRICE * size;
    }else{
      price =  productPrice * size;
    }
    return price;
  }
}
