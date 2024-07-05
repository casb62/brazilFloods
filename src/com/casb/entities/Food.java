package com.casb.entities;

import java.util.Date;
import java.util.Objects;

public class Food {
	
	private Long id;
	private String description;
	private String unitOfMeasurement;
	private Date validity;
	
	public Food() {
	}

	public Food(Long id, String description, String unitOfMeasurement, Date validity) {
		super();
		this.id = id;
		this.description = description;
		this.unitOfMeasurement = unitOfMeasurement;
		this.validity = validity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Food [id=" + id + ", description=" + description + ", unitOfMeasurement=" + unitOfMeasurement + ", validity="
				+ validity + "]";
	}
}