package com.casb.entities;

import java.util.Date;
import java.util.Objects;

public class Order {

	private Integer id;
	private Date date;
	private String status;
	private Integer shelterId;
	
	public Order() {
	}

	public Order(Integer id, Date date, String status, Integer shelterId) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.shelterId = shelterId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getShelterId() {
		return shelterId;
	}

	public void setShelterId(Integer shelterId) {
		this.shelterId = shelterId;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", status=" + status + ", shelterId=" + shelterId + "]";
	}
}
