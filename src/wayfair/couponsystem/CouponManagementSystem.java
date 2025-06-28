package wayfair.couponsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class CouponManagementSystem {
        Map<String, Categories> categoryParentCategoryMap = new HashMap<>();
        Map<String, List<Coupons>> categoryCouponMap = new HashMap<>();
        Map<String,Products> categoryProductsMap = new HashMap<>();
        private final Map<String, String> couponCache = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;


    /*    List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01","Discount:10%"},
                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01","Discount:15%"},
                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01","Discount:35%"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01","Discount:25%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01","Discount:50%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01","Discount:75%"}
                new String[]{"CategoryName:Bed & Bath", "CouponName:Big Savings for Bed & Bath", "DateModified:2030-01-01","Discount:75%"}*/
        public void initializeCategoryCouponMap() throws ParseException {
            Coupons coupon = new Coupons("Comforter Sets", "Comforters Sale",  LocalDate.parse("2020-01-01"),10.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Comforter Sets", "Cozy Comforter Coupon",LocalDate.parse("2020-01-01"),15.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Bedding", "Best Bedding Bargains",LocalDate.parse("2019-01-01"),35.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Bedding", "Savings on Bedding",LocalDate.parse("2019-01-01"),25.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Bed & Bath", "Low price for Bed & Bath",LocalDate.parse("2018-01-01"),50.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Bed & Bath", "Bed & Bath extravaganza",LocalDate.parse("2019-01-01"),75.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
            coupon = new Coupons("Bed & Bath", "Big Savings for Bed & Bath",LocalDate.parse("2030-01-01"),75.00);
            categoryCouponMap.computeIfAbsent(coupon.categoryName, k -> new ArrayList<>()).add(coupon);
        }

        /*
    *   List<String[]> categories = List.of(
        new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
        new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
        new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
        new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
        new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
        new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
        new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
    );*/
        public void initializeCategories() {
            Categories category = new Categories("Comforter Sets", "Bedding");
            categoryParentCategoryMap.put(category.categoryName, category);
            category = new Categories("Bedding", "Bed & Bath");
            categoryParentCategoryMap.put(category.categoryName, category);
            category = new Categories("Soap Dispensers", "Bathroom Accessories");
            categoryParentCategoryMap.put(category.categoryName, category);
            category = new Categories("Bathroom Accessories", "Bed & Bath");
            categoryParentCategoryMap.put(category.categoryName, category);
            category = new Categories("Toy Organizers", "Baby And Kids");
            categoryParentCategoryMap.put(category.categoryName, category);
        }

   /* List<Product> products = Arrays.asList(new Product("Cozy Comforter", "100.00", "Comforter Sets"),
            new Product("All-in-one Bedding Set", "50.00", "Bedding"),
            new Product("Infinite Soap Dispenser", "500.00", "Bathroom Accessories"),
            new Product("Rainbow Toy Box", "257.00", "Baby And Kids"));*/
    public void initializeProductCategories() {
        Products product = new Products("Cozy Comforter",100.00, "Comforter Sets");
        categoryProductsMap.put(product.getCategoryName(), product);
        product = new Products("All-in-one Bedding Set",50.00, "Bedding");
        categoryProductsMap.put(product.getCategoryName(), product);
        product = new Products("Infinite Soap Dispenser",500.00, "Bathroom Accessories");
        categoryProductsMap.put(product.getCategoryName(), product);
        product = new Products("Rainbow Toy Box",257.00, "Baby And Kids");
        categoryProductsMap.put(product.getCategoryName(), product);
    }

        public String getCoupon(String categoryName) {
            if (couponCache.containsKey(categoryName)) {
                return couponCache.get(categoryName);
            }

            String couponName = null;
            if (categoryCouponMap.containsKey(categoryName)) {
                List<Coupons> coupons = categoryCouponMap.get(categoryName);
                coupons=coupons.stream().filter(c->c.getDate().isBefore(LocalDate.now())).toList();
                if(!coupons.isEmpty()) {
                    List<Coupons> finalList= new ArrayList(coupons);
                    finalList.sort(Comparator.comparing(Coupons::getDate).reversed());
                    Coupons coup = coupons.get(0);
                    finalList = finalList.stream().
                            filter(c -> c.getDate().equals(coup.getDate()))
                            .toList();
                    if(!finalList.isEmpty()) {
                        Products product=categoryProductsMap.get(categoryName);
                        couponName = coupons.stream().map(Coupons::getCouponName).
                                collect(Collectors.joining(" | "));
                        if(Objects.nonNull(product)) {
                            String discounts = coupons.stream().map(c -> product.getPrice() - product.getPrice() * c.getDiscounts() / 100)
                                    .map(String::valueOf).collect(Collectors.joining("OR"));
                            couponName=couponName.concat(!discounts.isBlank() ? discounts : "");
                        }
                    }
                }
            } else if (categoryParentCategoryMap.containsKey(categoryName)) {
                Categories categories = categoryParentCategoryMap.get(categoryName);
                couponName = getCoupon(categories.getCategoryParentName());
            }
            couponCache.put(categoryName,categoryName);
            return couponName;
        }

    }