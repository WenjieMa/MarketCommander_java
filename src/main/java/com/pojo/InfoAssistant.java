package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoAssistant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_assistant", catalog = "marketcommander")

public class InfoAssistant implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String name;
	private String nickname;
	private Integer age;
	private Short gender;
	private String phone;
	private String email;
	private Integer storeid;
	private String idcard;
	private String bankcard;
	private String alipayaccount;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoAssistant() {
	}

	/** full constructor */
	public InfoAssistant(String username, String password, String name, String nickname, Integer age, Short gender,
			String phone, String email, Integer storeid, String idcard, String bankcard, String alipayaccount,
			Timestamp createdate, Timestamp updatedate) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.storeid = storeid;
		this.idcard = idcard;
		this.bankcard = bankcard;
		this.alipayaccount = alipayaccount;
		this.createdate = createdate;
		this.updatedate = updatedate;
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

	@Column(name = "nickname")

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "age")

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "gender")

	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "phone")

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email")

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "storeid")

	public Integer getStoreid() {
		return this.storeid;
	}

	public void setStoreid(Integer storeid) {
		this.storeid = storeid;
	}

	@Column(name = "idcard")

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "bankcard")

	public String getBankcard() {
		return this.bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	@Column(name = "alipayaccount")

	public String getAlipayaccount() {
		return this.alipayaccount;
	}

	public void setAlipayaccount(String alipayaccount) {
		this.alipayaccount = alipayaccount;
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