package com.casb.entities;

import java.util.Objects;

public class Clothing {
	
	private Integer id;
	private String description;
	private String gender;
	private String size;
	private String distributionCenter;
	
	public Clothing() {
	}

	public Clothing(Integer id, String description, String gender, String size, String distributionCenter) {
		super();
		this.id = id;
		this.description = description;
		this.gender = gender;
		this.size = size;
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
		Clothing other = (Clothing) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Clothing [id=" + id + ", description=" + description + ", gender=" + gender + ", size=" + size
				+ ", distributionCenter=" + distributionCenter + "]";
	}

	

}