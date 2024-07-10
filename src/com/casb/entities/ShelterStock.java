package com.casb.entities;

import java.util.Date;
import java.util.Objects;

public class ShelterStock {

	private Integer id;
	private String description;
	private String unitOfMeasurement;
	private String gender;
	private String size;
	private Date validity;
	private Integer categoryId;
	private Integer shelterId;
	
	public ShelterStock() {
	}

	public ShelterStock(Integer id, String description, String unitOfMeasurement, String gender, String size,
			Date validity, Integer categoryId, Integer shelterId) {
		super();
		this.id = id;
		this.description = description;
		this.unitOfMeasurement = unitOfMeasurement;
		this.gender = gender;
		this.size = size;
		this.validity = validity;
		this.categoryId = categoryId;
		this.shelterId = shelterId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
		ShelterStock other = (ShelterStock) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ShelterStock [id=" + id + ", description=" + description + ", unitOfMeasurement=" + unitOfMeasurement
				+ ", gender=" + gender + ", size=" + size + ", validity=" + validity + ", categoryId=" + categoryId
				+ ", shelterId=" + shelterId + "]";
	}
}
