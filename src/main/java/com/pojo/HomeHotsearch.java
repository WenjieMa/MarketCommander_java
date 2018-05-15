package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * HomeHotsearch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "home_hotsearch", catalog = "marketcommander")

public class HomeHotsearch implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long amount;
	private Short iseffective;
	private String name;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeHotsearch() {
	}

	/** full constructor */
	public HomeHotsearch(Long amount, Short iseffective, String name, Timestamp createdate) {
		this.amount = amount;
		this.iseffective = iseffective;
		this.name = name;
		this.createdate = createdate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "amount")

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Column(name = "iseffective")

	public Short getIseffective() {
		return this.iseffective;
	}

	public void setIseffective(Short iseffective) {
		this.iseffective = iseffective;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}