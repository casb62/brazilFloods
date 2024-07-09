package com.casb.entities;

import java.util.Objects;

public class Hygiene {
	
	private Integer id;
	private String description;
	private String distributionCenter;
	
	public Hygiene() {
	}

	public Hygiene(Integer id, String description, String distributionCenter) {
		super();
		this.id = id;
		this.description = description;
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
		Hygiene other = (Hygiene) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Hygiene [id=" + id + ", description=" + description + ", distributionCenter=" + distributionCenter + "]";
	}
}