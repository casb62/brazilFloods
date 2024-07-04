package com.casb.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import com.casb.entities.enums.PersonStatus;

public class Person {

	private Long id;
	private String name;
	private Date dateOfBirth;
	private char gender;
	private Instant arrival;
	private Instant departure;
	private PersonStatus personStatus;
	
	public Person() {
	}

	public Person(Long id, String name, Date dateOfBirth, char gender, Instant arrival, Instant departure,
			PersonStatus personStatus) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.arrival = arrival;
		this.departure = departure;
		this.personStatus = personStatus;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Instant getArrival() {
		return arrival;
	}

	public void setArrival(Instant arrival) {
		this.arrival = arrival;
	}

	public Instant getDeparture() {
		return departure;
	}

	public void setDeparture(Instant departure) {
		this.departure = departure;
	}

	public PersonStatus getPersonStatus() {
		return personStatus;
	}

	public void setPersonStatus(PersonStatus personStatus) {
		this.personStatus = personStatus;
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
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", arrival=" + arrival + ", departure=" + departure + ", personStatus=" + personStatus + "]";
	}
}
