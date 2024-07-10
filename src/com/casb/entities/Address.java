package com.casb.entities;

import java.util.Objects;

public class Address {

	private Integer id;
	private String publicPlace;
	private String number;
	private String neighborhood;
	private String city;
	private String federationUnity;
	private String zipcode;
	
	public Address() {
	}

	public Address(Integer id, String publicPlace, String number, String neighborhood, String city,
			String federationUnity, String zipcode) {
		super();
		this.id = id;
		this.publicPlace = publicPlace;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.federationUnity = federationUnity;
		this.zipcode = zipcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFederationUnity() {
		return federationUnity;
	}

	public void setFederationUnity(String federationUnity) {
		this.federationUnity = federationUnity;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", publicPlace=" + publicPlace + ", number=" + number + ", neighborhood="
				+ neighborhood + ", city=" + city + ", federationUnity=" + federationUnity + ", zipcode=" + zipcode
				+ "]";
	}
}
