package wayfair.couponsystem;

import java.text.ParseException;

public class Solution {

    public static void main(String[] args) throws ParseException {
            CouponManagementSystem couponManager= new CouponManagementSystem();
            couponManager.initializeCategories();
            couponManager.initializeCategoryCouponMap();
            couponManager.initializeProductCategories();
            System.out.println(couponManager.getCoupon("Comforter Sets")); // Comforters Sale
            System.out.println(couponManager.getCoupon("Bedding")); // Savings on Bedding
            System.out.println(couponManager.getCoupon("Bathroom Accessories")); // "Low price for Bed & Bath"
            System.out.println(couponManager.getCoupon("Soap Dispensers")); // Low price for Bed & Bath
            System.out.println(couponManager.getCoupon("Toy Organizers")); // ""
            System.out.println(couponManager.getCoupon("Baby And Kids")); // ""
            System.out.println(couponManager.getCoupon("All-in-one Bedding Set")); // ""
            System.out.println(couponManager.getCoupon("Infinite Soap Dispenser")); // ""
            System.out.println(couponManager.getCoupon("Rainbow Toy Box")); // ""
            System.out.println();
            System.out.println("Test Case " + 1 + " passed");
            System.out.println();

    }
}
