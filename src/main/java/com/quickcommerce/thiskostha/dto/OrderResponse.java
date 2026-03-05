package com.quickcommerce.thiskostha.dto;

import com.quickcommerce.thiskostha.entity.Address;

public class OrderResponse {
	  private Long id;
	  private Double distance;
	  private Double deliveryCharges;
	  private Double totalCost;
	  private Address pickupAddress;
	  private Address deliveryAddress;
	  public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	  public Long getId() {
		return id;
	}
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public Double getDistance() {
		  return distance;
	  }
	  public void setDistance(Double distance) {
		  this.distance = distance;
	  }
	  public Double getDeliveryCharges() {
		  return deliveryCharges;
	  }
	  public void setDeliveryCharges(Double deliveryCharges) {
		  this.deliveryCharges = deliveryCharges;
	  }
	  public Double getTotalCost() {
		  return totalCost;
	  }
	  public void setTotalCost(Double totalCost) {
		  this.totalCost = totalCost;
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
	  public OrderResponse(Long id, Double distance, Double deliveryCharges, Double totalCost, Address pickupAddress,
			Address deliveryAddress) {
		super();
		this.id = id;
		this.distance = distance;
		this.deliveryCharges = deliveryCharges;
		this.totalCost = totalCost;
		this.pickupAddress = pickupAddress;
		this.deliveryAddress = deliveryAddress;
	  }
}
