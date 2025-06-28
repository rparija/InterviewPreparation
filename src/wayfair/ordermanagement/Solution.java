package wayfair.ordermanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);
        IOrderSystem orderSystem= new OrderSystem();
        int oCount= Integer.parseInt(buf.readLine().trim());

        for (int i = 1; i <= oCount; i++) {
            String[] a = buf.readLine().trim().split(" ");
            Order order = new Order();
            order.setName(a[0]);
            order.setUnitPrice((double) Integer.parseInt(a[1]));
            order.setQuantity(Integer.parseInt(a[2]));
            orderSystem.addToCart(order);
        }
        orderSystem.getCategoryDiscount();
        Double totalAmount = orderSystem.calculateTotalAmount();
        textWriter.println("Total Amount: " + totalAmount);
        Map<String, Double> categoryDiscounts = orderSystem.getCategoryDiscount();
        for (Map.Entry<String, Double> entry : categoryDiscounts.entrySet()) {
            if(entry.getValue() > 0) {
                textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
            }
        }

        Map<String, Order> cartItems = orderSystem.getItemsWithQuantityFromCart();
        for (Map.Entry<String, Order> entry : cartItems.entrySet()) {
            textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }
        textWriter.flush();
        textWriter.close();

    }
}
