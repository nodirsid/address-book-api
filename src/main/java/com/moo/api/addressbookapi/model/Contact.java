package com.moo.api.addressbookapi.model;

import java.util.List;
import java.util.Objects;

public class Contact {

	private Long id;
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String address;

	public Contact(String firstName, String lastName, int age, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(this.getFirstName(), contact.getFirstName()) &&
                Objects.equals(this.getLastName(), contact.getLastName()) &&
                Objects.equals(this.getAddress(), contact.getAddress()) &&
                this.getAge() == contact.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, age);
    }
}
