package com.casb.entities;

import java.util.Date;
import java.util.Objects;

public class Food {
	
	private Long id;
	private String type;
	private String unitOfMeasurement;
	private Date validity;
	
	public Food() {
	}

	public Food(Long id, String type, String unitOfMeasurement, Date validity) {
		super();
		this.id = id;
		this.type = type;
		this.unitOfMeasurement = unitOfMeasurement;
		this.validity = validity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
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
		Food other = (Food) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", type=" + type + ", unitOfMeasurement=" + unitOfMeasurement + ", validity="
				+ validity + "]";
	}
}