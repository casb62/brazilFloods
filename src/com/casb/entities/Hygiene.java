package com.casb.entities;

import java.util.Objects;

public class Hygiene {
	
	private Long id;
	private String type;
	private String unitOfMeasurement;
	
	public Hygiene() {
	}

	public Hygiene(Long id, String type, String unitOfMeasurement) {
		super();
		this.id = id;
		this.type = type;
		this.unitOfMeasurement = unitOfMeasurement;
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
		return "Hygiene [id=" + id + ", type=" + type + ", unitOfMeasurement=" + unitOfMeasurement + "]";
	}
}