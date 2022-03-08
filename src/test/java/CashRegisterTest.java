import checkout.CheckOut;
import checkout.CheckOutStoreOne;
import checkout.CheckOutStoreTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import product.Product;

class CashRegisterTest {

  @Test
  void testNoApplyDiscountScenario() {

//VOUCHER, TSHIRT, PANTS - Total: 32.50
    CheckOut checkOut = new CheckOutStoreOne();
    CashRegister cashier = new CashRegister(checkOut);
    cashier.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashier.addItem(new Product("PANTS","Summer Pants",7.50));
    cashier.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    var result = cashier.getTotalAmount();

    Assertions.assertEquals(32.50,result);

  }

  @Test
  void testApplyDiscountScenario2() {

   // VOUCHER, TSHIRT, VOUCHER - Total: 25.00€
    CheckOut checkOut = new CheckOutStoreOne();
    CashRegister cashier = new CashRegister(checkOut);
    cashier.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashier.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashier.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    var result = cashier.getTotalAmount();

    Assertions.assertEquals(25.00,result);

  }

  @Test
  void testApplyDiscountScenario3() {

    // TSHIRT, TSHIRT, TSHIRT, VOUCHER, TSHIRT - Total: 81.00€
    CheckOut checkOut = new CheckOutStoreOne();
    CashRegister cashRegister = new CashRegister(checkOut);
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    var result = cashRegister.getTotalAmount();

    Assertions.assertEquals(81.00,result);

  }



  @Test
  void testApplyDiscountScenario4() {

    //   VOUCHER, TSHIRT, VOUCHER, VOUCHER, PANTS, TSHIRT, TSHIRT - Total: 74.50€
    CheckOut checkOut = new CheckOutStoreOne();
    CashRegister cashRegister = new CashRegister(checkOut);
    cashRegister.addItem(new Product("PANTS","Summer Pants",7.50));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    var result = cashRegister.getTotalAmount();

    Assertions.assertEquals(74.50,result);

  }

  @Test
  void testApplyDiscountOnCheckOutStoreTwo() {

    //   VOUCHER, TSHIRT, VOUCHER, VOUCHER, PANTS,PANTS,PANTS,TSHIRT, TSHIRT - Total: (90)€
    CheckOut checkOut = new CheckOutStoreTwo();
    CashRegister cashRegister = new CashRegister(checkOut);
    cashRegister.addItem(new Product("PANTS","Summer Pants",7.50));
    cashRegister.addItem(new Product("PANTS","Summer Pants",7.50));
    cashRegister.addItem(new Product("PANTS","Summer Pants",7.50));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("VOUCHER","Gift Card",5.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    cashRegister.addItem(new Product("TSHIRT","Summer T-Shirt",20.00));
    var result = cashRegister.getTotalAmount();
    Assertions.assertEquals(90.00,result);

  }

}
