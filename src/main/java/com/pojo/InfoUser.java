package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * InfoUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_user", catalog = "marketcommander")

public class InfoUser implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String password;
	private Boolean gender;
	private String signature;
	private String headpic;
	private Boolean iseffective;
	private String phone;
	private String email;
	private String nickname;
	private String name;
	private Date birthdate;
	private Long questionid1;
	private String answer1;
	private Long questionid2;
	private String answer2;
	private String lastloginip;
	private Timestamp lastlogindate;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoUser() {
	}

	/** minimal constructor */
	public InfoUser(String username, String password, Timestamp createdate) {
		this.username = username;
		this.password = password;
		this.createdate = createdate;
	}

	/** full constructor */
	public InfoUser(String username, String password, Boolean gender, String signature, String headpic,
			Boolean iseffective, String phone, String email, String nickname, String name, Date birthdate,
			Long questionid1, String answer1, Long questionid2, String answer2, String lastloginip,
			Timestamp lastlogindate, Timestamp createdate, Timestamp updatedate) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.signature = signature;
		this.headpic = headpic;
		this.iseffective = iseffective;
		this.phone = phone;
		this.email = email;
		this.nickname = nickname;
		this.name = name;
		this.birthdate = birthdate;
		this.questionid1 = questionid1;
		this.answer1 = answer1;
		this.questionid2 = questionid2;
		this.answer2 = answer2;
		this.lastloginip = lastloginip;
		this.lastlogindate = lastlogindate;
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

	@Column(name = "username", nullable = false)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "gender")

	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Column(name = "signature")

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "headpic")

	public String getHeadpic() {
		return this.headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	@Column(name = "iseffective")

	public Boolean getIseffective() {
		return this.iseffective;
	}

	public void setIseffective(Boolean iseffective) {
		this.iseffective = iseffective;
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

	@Column(name = "nickname")

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 10)

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "questionid1")

	public Long getQuestionid1() {
		return this.questionid1;
	}

	public void setQuestionid1(Long questionid1) {
		this.questionid1 = questionid1;
	}

	@Column(name = "answer1")

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	@Column(name = "questionid2")

	public Long getQuestionid2() {
		return this.questionid2;
	}

	public void setQuestionid2(Long questionid2) {
		this.questionid2 = questionid2;
	}

	@Column(name = "answer2")

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	@Column(name = "lastloginip")

	public String getLastloginip() {
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}

	@Column(name = "lastlogindate", length = 19)

	public Timestamp getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(Timestamp lastlogindate) {
		this.lastlogindate = lastlogindate;
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