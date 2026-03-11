package com.quickcommerce.thiskostha.service;

import java.util.HashSet;
import java.util.Set;

public class CouponRedemptionService {

    private Set<String> usedCoupons = new HashSet<>();

    public boolean validateCoupon(String couponCode) {
        // Implement logic for validating coupon (e.g., check format, expiration date)
        return true; // Assume valid for example
    }

    public boolean redeemCoupon(String couponCode, String customerId) {
        if (validateCoupon(couponCode)) {
            if (hasCustomerUsedCoupon(customerId, couponCode)) {
                return false; // Customer has already used this coupon
            } else {
                usedCoupons.add(couponCode);
                // Implement additional logic for redemption
                return true;
            }
        }
        return false; // Invalid coupon
    }

    public boolean hasCustomerUsedCoupon(String customerId, String couponCode) {
        // Implement logic to check if a customer has used the coupon
        return usedCoupons.contains(couponCode); // Simple check for example
    }
}