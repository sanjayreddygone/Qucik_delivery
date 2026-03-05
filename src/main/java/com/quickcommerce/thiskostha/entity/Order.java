package com.quickcommerce.thiskostha.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private LocalDateTime orderTime;
    @Enumerated(EnumType.STRING)
    private OrderStatus deliveryStatus;
    private Integer otp;
   
    private String deliveryInstructions;
    private String specialinstructions;
    private Double distance;
    private LocalDateTime deliveryTime;
 

    private Double cost;
    private Double deliveryCharges;
    private Double packagingFee;
    private Double platformFee ;
    private Double tax;
    private Double totalCost;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    
    @ManyToOne
    @JoinColumn(name="pickup_address_id")
    private Address pickupAddress;
    
    @ManyToOne
    @JoinColumn(name="delivery_address_id")
    private Address deliveryAddress;
    
    @OneToMany
    @JoinColumn(name="order_id")
    
    private List<CartItem> items;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    private DeliveryPartner deliveryPartner;
    
    @OneToOne(mappedBy="order",cascade = CascadeType.ALL)
    private Payment payment;

	public Order(Long id, PaymentStatus paymentStatus, LocalDateTime orderTime, OrderStatus deliveryStatus, Integer otp,
			String deliveryInstructions, String specialinstructions, Double distance, LocalDateTime deliveryTime,
			Double cost, Double deliveryCharges, Double packagingFee, Double platformFee, Double tax, Double totalCost,
			Restaurant restaurant, Address pickupAddress, Address deliveryAddress, List<CartItem> items,
			Customer customer, DeliveryPartner deliveryPartner, Payment payment) {
		super();
		this.id = id;
		this.paymentStatus = paymentStatus;
		this.orderTime = orderTime;
		this.deliveryStatus = deliveryStatus;
		this.otp = otp;
		this.deliveryInstructions = deliveryInstructions;
		this.specialinstructions = specialinstructions;
		this.distance = distance;
		this.deliveryTime = deliveryTime;
		this.cost = cost;
		this.deliveryCharges = deliveryCharges;
		this.packagingFee = packagingFee;
		this.platformFee = platformFee;
		this.tax = tax;
		this.totalCost = totalCost;
		this.restaurant = restaurant;
		this.pickupAddress = pickupAddress;
		this.deliveryAddress = deliveryAddress;
		this.items = items;
		this.customer = customer;
		this.deliveryPartner = deliveryPartner;
		this.payment = payment;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public OrderStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(OrderStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	public String getSpecialinstructions() {
		return specialinstructions;
	}

	public void setSpecialinstructions(String specialinstructions) {
		this.specialinstructions = specialinstructions;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(Double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public Double getPackagingFee() {
		return packagingFee;
	}

	public void setPackagingFee(Double packagingFee) {
		this.packagingFee = packagingFee;
	}

	public Double getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(Double platformFee) {
		this.platformFee = platformFee;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Address getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeliveryPartner getDeliveryPartner() {
		return deliveryPartner;
	}

	public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
    


	

}