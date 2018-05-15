package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoExpress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_express", catalog = "marketcommander")

public class InfoExpress implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String contactname;
	private String phone;
	private String adress;
	private Short iseffective;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public InfoExpress() {
	}

	/** full constructor */
	public InfoExpress(String name, String contactname, String phone, String adress, Short iseffective,
			Timestamp createdate) {
		this.name = name;
		this.contactname = contactname;
		this.phone = phone;
		this.adress = adress;
		this.iseffective = iseffective;
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

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "contactname")

	public String getContactname() {
		return this.contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	@Column(name = "phone")

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "adress")

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "iseffective")

	public Short getIseffective() {
		return this.iseffective;
	}

	public void setIseffective(Short iseffective) {
		this.iseffective = iseffective;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}