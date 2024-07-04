package com.casb.entities;

import java.util.Objects;

public class Clothing {
	
	private Long id;
	private String type;
	private char gender;
	private String size;
	
	public Clothing() {
	}

	public Clothing(Long id, String type, char gender, String size) {
		super();
		this.id = id;
		this.type = type;
		this.gender = gender;
		this.size = size;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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
		return "Clothing [id=" + id + ", type=" + type + ", gender=" + gender + ", size=" + size + "]";
	}

}