package wayfair.couponsystem;

import java.time.LocalDate;

/*
*   List<Product> products = Arrays.asList(new Product("Cozy Comforter", "100.00", "Comforter Sets"),
				new Product("All-in-one Bedding Set", "50.00", "Bedding"),
				new Product("Infinite Soap Dispenser", "500.00", "Bathroom Accessories"),
				new Product("Rainbow Toy Box", "257.00", "Baby And Kids"));
* */
public class Products {
    String productName;
    Double price;
    String categoryName;

    public Products(String productName, double price, String categoryName) {
        this.productName=productName;
        this.price=price;
        this.categoryName=categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
