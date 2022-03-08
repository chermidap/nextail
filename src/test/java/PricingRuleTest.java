import static org.junit.jupiter.api.Assertions.assertEquals;

import checkout.CheckOutStoreOne;
import checkout.CheckOutStoreTwo;
import java.util.List;
import org.junit.jupiter.api.Test;
import pricing.PantsPricingRule;
import pricing.PantsPricingRuleTwo;
import pricing.PricingRule;
import pricing.TshirtPricingRule;
import pricing.VoucherPricingRuleOne;
import pricing.VoucherPricingRuleTwo;
import product.Product;
import product.ProductType;

class PricingRuleTest {

  @Test
  void testApplyDiscountTshirt() {

    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("TSHIRT", "Summer T-Shirt", 20.00);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 3L);
    assertEquals(57.00, result);

  }

  @Test
  void testNoApplyDiscountSuccessTshirt() {

    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("TSHIRT", "Summer T-Shirt", 20.00);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 2L);
    assertEquals(40, result);

  }

  @Test
  void testApplyDiscountVoucher() {
    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("VOUCHER", "Gift Card", 5.00);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 3L);
    assertEquals(10.00, result);

  }

  @Test
  void testNoApplyDiscountSuccessVoucher() {
    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("VOUCHER", "Gift Card", 5.00);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 2L);
    assertEquals(5.00, result);

  }

  @Test
  void testApplyDiscountWith4Voucher() {
    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("VOUCHER", "Gift Card", 5.00);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 4L);
    assertEquals(10.00, result);

  }

  @Test
  void testApplyNoDiscountWithPantsCheckOutOne() {
    var checkOut = new CheckOutStoreOne(getPricingRulesScenarioOne());
    var item = new Product("PANTS", "Summer Pants", 7.50);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 2L);
    assertEquals(15.00, result);

  }

  @Test
  void testApplyDiscountWithPantsCheckOutTwo() {
    var checkOut = new CheckOutStoreTwo(getPricingRulesScenarioTwo());
    var item = new Product("PANTS", "Summer Pants", 7.50);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 3L);
    assertEquals(18.00, result);

  }

  @Test
  void testApplyDiscountWithEmptyProduct() {
    var checkOut = new CheckOutStoreTwo(getPricingRulesScenarioOne());
    var item = new Product("", "", 0d);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 1L);
    assertEquals(0, result);
  }

  @Test
  void testApplyDiscountWithNoExistingDiscountForProduct() {
    var checkOut = new CheckOutStoreTwo(getPricingRulesScenarioOne());
    var item = new Product("COAT", "winter coat", 40.0);
    var pricingRule = checkOut.scan(item);
    var result = pricingRule.applyDiscount(item.getPrice(), 1L);
    assertEquals(40, result);
  }

  private List<PricingRule> getPricingRulesScenarioOne(){
    PricingRule pricingVoucherRule = new VoucherPricingRuleOne(ProductType.VOUCHER);
    PricingRule pricingPantsRule = new PantsPricingRule(ProductType.PANTS);
    PricingRule pricingTshirtRulerRule = new TshirtPricingRule(ProductType.TSHIRT);

    return List.of(pricingVoucherRule,pricingPantsRule,pricingTshirtRulerRule);
  }

  private List<PricingRule> getPricingRulesScenarioTwo(){
    PricingRule pricingVoucherRule = new VoucherPricingRuleTwo(ProductType.VOUCHER);
    PricingRule pricingPantsRule = new PantsPricingRuleTwo(ProductType.PANTS);
    PricingRule pricingTshirtRulerRule = new TshirtPricingRule(ProductType.TSHIRT);

    return List.of(pricingVoucherRule,pricingPantsRule,pricingTshirtRulerRule);
  }
}
