package com.casb.entities;

import java.util.Date;
import java.util.Objects;

public class Food {
	
	private Integer id;
	private String description;
	private String unitOfMeasurement;
	private Date validity;
	private String distributionCenter;
	
	public Food() {
	}

	public Food(Integer id, String description, String unitOfMeasurement, Date validity, String distributionCenter) {
		super();
		this.id = id;
		this.description = description;
		this.unitOfMeasurement = unitOfMeasurement;
		this.validity = validity;
		this.distributionCenter = distributionCenter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getDistributionCenter() {
		return distributionCenter;
	}

	public void setDistributionCenter(String distributionCenter) {
		this.distributionCenter = distributionCenter;
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
		return "Food [id=" + id + ", description=" + description + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", validity=" + validity + ", distributionCenter=" + distributionCenter + "]";
	}

}