package com.casb.entities;

import java.util.Objects;

public class OrderItem {

	private Integer id;
	private Integer orderId;
	private Integer donationId;
	
	public OrderItem() {
	}

	public OrderItem(Integer id, Integer orderId, Integer donationId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.donationId = donationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getDonationId() {
		return donationId;
	}

	public void setDonationId(Integer donationId) {
		this.donationId = donationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", donationId=" + donationId + "]";
	}
}
