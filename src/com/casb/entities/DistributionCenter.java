package com.casb.entities;

import java.util.Objects;

public class DistributionCenter {

	private Integer id;
	private String name;
	private Integer addressId;
	
	public DistributionCenter() {
	}

	public DistributionCenter(Integer id, String name, Integer addressId) {
		super();
		this.id = id;
		this.name = name;
		this.addressId = addressId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
		DistributionCenter other = (DistributionCenter) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DistributionCenter [id=" + id + ", name=" + name + ", addressId=" + addressId + "]";
	}
}