package com.quickcommerce.thiskostha.dto;

public class OrderConsent {

    private Long orderId;
    private String restaurantName;
    private double itemCost;
    private double deliveryCharges;
    private double packagingFees;
    private double tax;
    private double platformFees;
    private double totalCost;
    private double distance;

    public OrderConsent(double deliveryCharges, double distance,
                            double itemCost, Long orderId, double packagingFees, double platformFees, String restaurantName,
                            double tax, double totalCost) {
        this.deliveryCharges = deliveryCharges;
        this.distance = distance;
        this.itemCost = itemCost;
        this.orderId = orderId;
        this.packagingFees = packagingFees;
        this.platformFees = platformFees;
        this.restaurantName = restaurantName;
        this.tax = tax;
        this.totalCost = totalCost;
    }

    public OrderConsent() {
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getPackagingFees() {
        return packagingFees;
    }

    public void setPackagingFees(double packagingFees) {
        this.packagingFees = packagingFees;
    }

    public double getPlatformFees() {
        return platformFees;
    }

    public void setPlatformFees(double platformFees) {
        this.platformFees = platformFees;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
