import checkout.CheckOut;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import product.Product;

public class CashRegister {

  private final List<Product> items;

  private final CheckOut checkout;

  private double total;

  public CashRegister(CheckOut checkout) {
    this.checkout = checkout;
    this.items = new ArrayList<>();
  }

  public double getTotalAmount() {
    Map<Product, Long> productCounterMap = items.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    calculateTotalPrice(productCounterMap);
    return total;

  }

  public void addItem(Product product) {
    items.add(product);
  }

  private void calculateTotalPrice(Map<Product, Long> map) {
    map.forEach((k, v) -> {
      var result = checkout.scan(k).applyDiscount(k, v.intValue());
      total = total + result;
    });
  }
}
