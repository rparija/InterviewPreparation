package wayfair.ordermanagement;

import java.util.Map;

public interface IOrderSystem {

    void addToCart(Order order);
    void removeFromCart(Order order);
    Double calculateDiscountedPrice(Order order);
    Map<String,Double> getCategoryDiscount();
    Map<String, Order> getItemsWithQuantityFromCart();
    String calculateCategory(Double totalCartValue);
    Double calculateTotalAmount();
}
