package com.learning.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	
	@Column(length = 70, nullable = true)
	private String street;
	
	@Column(length = 40)
	private String city;
	
	@Transient
	private boolean isSafe;
	
	private double rating;
	@Lob
	private byte[] image;
	
	@Temporal(TemporalType.DATE)
	private Date dateAdded;

	public Address() {
		super();
	}

	public Address(int addressId, String street, String city, boolean isSafe, double rating, Date dateAdded,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isSafe = isSafe;
		this.rating = rating;
		this.dateAdded = dateAdded;
		this.image = image;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isSafe() {
		return isSafe;
	}

	public void setSafe(boolean isSafe) {
		this.isSafe = isSafe;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isSafe=" + isSafe
				+ ", rating=" + rating + ", dateAdded=" + dateAdded + ", image=" + Arrays.toString(image) + "]";
	}

}
