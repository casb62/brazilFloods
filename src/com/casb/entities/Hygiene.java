package com.casb.entities;

import java.util.Objects;

public class Hygiene {
	
	private Long id;
	private String description;
	private String unitOfMeasurement;
	
	public Hygiene() {
	}

	public Hygiene(Long id, String description, String unitOfMeasurement) {
		super();
		this.id = id;
		this.description = description;
		this.unitOfMeasurement = unitOfMeasurement;
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
		Hygiene other = (Hygiene) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Hygiene [id=" + id + ", description=" + description + ", unitOfMeasurement=" + unitOfMeasurement + "]";
	}
}