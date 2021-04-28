package com.test.soap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Address.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/** The number. */
	@Column(name = "number")
	private Integer number;

	/** The street. */
	@Column(name = "street")
	private String street;

	/** The zipcode. */
	@Column(name = "zipcode")
	private String zipcode;

	/** The merchant. */
	@ManyToOne
	private Merchant merchant;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the merchant.
	 *
	 * @return the merchant
	 */
	public Merchant getMerchantj() {
		return merchant;
	}

	/**
	 * Sets the merchant.
	 *
	 * @param merchant the new merchant
	 */
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
}
