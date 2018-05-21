package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoOperator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_operator", catalog = "marketcommander")

public class InfoOperator implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String password;
	private String name;
	private String phone;
	private int gender;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoOperator() {
	}

	/** full constructor */
	public InfoOperator(String username, String password, String name, String phone, int gender,
			Timestamp createdate, Timestamp updatedate) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
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

	@Column(name = "username")

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone")

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "gender")

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "createdate", length = 19)

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