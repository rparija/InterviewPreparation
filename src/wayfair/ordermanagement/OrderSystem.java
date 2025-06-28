package wayfair.ordermanagement;

import java.util.HashMap;
import java.util.Map;

public class OrderSystem implements IOrderSystem{

    Map<String,Double> categoryDiscount = new HashMap<String,Double>();
    Map<String,Order> cart= new HashMap<String,Order>();
    final String CHEAP="cheap";
    final String MODERATE="moderate";
    final String EXPENSIVE="expensive";

    @Override
    public void addToCart(Order order) {
        cart.put(order.getName(),order);
    }

    @Override
    public void removeFromCart(Order order) {
        cart.remove(order.getName());
    }

    @Override
    public Double calculateDiscountedPrice(Order order) {
        double totalCartValue=order.getUnitPrice()*order.getQuantity();
        String category=calculateCategory(totalCartValue);
        Double discount=categoryDiscount.get(category);
        return totalCartValue-(totalCartValue*discount)/100;
    }

    @Override
    public Map<String, Double> getCategoryDiscount() {
        categoryDiscount.put(CHEAP,10D);
        categoryDiscount.put(MODERATE,20D);
        categoryDiscount.put(EXPENSIVE,30D);
        return categoryDiscount;
    }

    @Override
    public Map<String, Order> getItemsWithQuantityFromCart() {
        return cart;
    }

    @Override
    public String calculateCategory(Double totalCartValue) {
        if(totalCartValue<=10)
        {
            return CHEAP;
        }
        else if(totalCartValue>10 && totalCartValue<20)
        {
            return MODERATE;
        }
        else
        {
            return EXPENSIVE;
        }
    }

    @Override
    public Double calculateTotalAmount() {
        return cart.values().stream().
                mapToDouble(this::calculateDiscountedPrice).sum();
    }

}
