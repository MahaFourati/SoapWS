package com.test.soap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/** The create date. */
	@Column(name = "create_date")
	private Date createDate;

	/** The label. */
	@Column(name = "label")
	private String label;

	/** The unit price. */
	@Column(name = "unit_price")
	private Double unitPrice;

	/** The currency. */
	@Column(name = "currency")
	private String currency;

	/** The weight. */
	@Column(name = "weight")
	private Double weight;

	/** The height. */
	@Column(name = "height")
	private Double height;

	/** The merchants. */
	@OneToMany(mappedBy = "id.product")
	private List<AffectationProduit> merchants;

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
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return the unit price
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param unitPrice the new unit price
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * Gets the merchants.
	 *
	 * @return the merchants
	 */
	public List<AffectationProduit> getMerchants() {
		return merchants;
	}

	/**
	 * Sets the merchants.
	 *
	 * @param merchants the new merchants
	 */
	public void setMerchants(List<AffectationProduit> merchants) {
		this.merchants = merchants;
	}

}
