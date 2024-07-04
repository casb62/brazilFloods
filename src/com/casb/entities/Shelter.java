package com.casb.entities;

import java.util.Objects;

public class Shelter {
	
	private Long id;
	private String name;
	private String publicPlace;
	private String number;
	private String neighborhood;
	private String city;
	private String federationUnity;
	private String zipCode;
	private String sponsor;
	private String phone;
	private String email;
	private Integer capacity;
	private Integer amountOfPeople;
	
	public Shelter() {
	}

	public Shelter(Long id, String name, String publicPlace, String number, String neighborhood, String city,
			String federationUnity, String zipCode, String sponsor, String phone, String email, Integer capacity,
			Integer amountOfPeople) {
		super();
		this.id = id;
		this.name = name;
		this.publicPlace = publicPlace;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.federationUnity = federationUnity;
		this.zipCode = zipCode;
		this.sponsor = sponsor;
		this.phone = phone;
		this.email = email;
		this.capacity = capacity;
		this.amountOfPeople = amountOfPeople;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAmountOfPeople() {
		return amountOfPeople;
	}

	public void setAmountOfPeople(Integer amountOfPeople) {
		this.amountOfPeople = amountOfPeople;
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
		Shelter other = (Shelter) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Shelter [id=" + id + ", name=" + name + ", publicPlace=" + publicPlace + ", number=" + number
				+ ", neighborhood=" + neighborhood + ", city=" + city + ", federationUnity=" + federationUnity
				+ ", zipCode=" + zipCode + ", sponsor=" + sponsor + ", phone=" + phone + ", email=" + email
				+ ", capacity=" + capacity + ", amountOfPeople=" + amountOfPeople + "]";
	}
}