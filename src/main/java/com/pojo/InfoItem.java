package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_item", catalog = "marketcommander")

public class InfoItem implements java.io.Serializable {

	// Fields

	private Long id;
	private Long typeid;
	private String name;
	private Double price;
	private Boolean iseffective;
	private Long likes;
	private Long store;
	private Boolean isoff;
	private Float discount;
	private String textbig;
	private String textsmall;
	private String description;
	private String itempic;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoItem() {
	}

	/** minimal constructor */
	public InfoItem(Timestamp createdate) {
		this.createdate = createdate;
	}

	/** full constructor */
	public InfoItem(Long typeid, String name, Double price, Boolean iseffective, Long likes,Long store, Boolean isoff,
			Float discount, String textbig, String textsmall, String description,
			String itempic, Timestamp createdate, Timestamp updatedate) {
		this.typeid = typeid;
		this.name = name;
		this.price = price;
		this.iseffective = iseffective;
		this.likes = likes;
		this.store = store;
		this.isoff = isoff;
		this.discount = discount;
		this.textbig = textbig;
		this.textsmall = textsmall;
		this.description = description;
		this.itempic = itempic;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "typeid")

	public Long getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 10)

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "iseffective")

	public Boolean getIseffective() {
		return this.iseffective;
	}

	public void setIseffective(Boolean iseffective) {
		this.iseffective = iseffective;
	}

	@Column(name = "likes")

	public Long getLikes() {
		return this.likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	@Column(name = "store")

	public Long getStore() {
		return this.store;
	}

	public void setStore(Long store) {
		this.store = store;
	}

	@Column(name = "isoff")

	public Boolean getIsoff() {
		return this.isoff;
	}

	public void setIsoff(Boolean isoff) {
		this.isoff = isoff;
	}

	@Column(name = "discount", precision = 3)

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Column(name = "textbig")

	public String getTextbig() {
		return this.textbig;
	}

	public void setTextbig(String textbig) {
		this.textbig = textbig;
	}

	@Column(name = "itempic")

	public String getItempic() {
		return this.itempic;
	}

	public void setItempic(String itempic) {
		this.itempic = itempic;
	}

	@Column(name = "textsmall")

	public String getTextsmall() {
		return this.textsmall;
	}

	public void setTextsmall(String textsmall) {
		this.textsmall = textsmall;
	}

	@Column(name = "description")

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "createdate", nullable = false, length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Column(name = "updatedate", length = 19)

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

}