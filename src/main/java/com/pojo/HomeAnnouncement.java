package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * HomeAnnouncement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "home_announcement", catalog = "marketcommander")

public class HomeAnnouncement implements java.io.Serializable {

	// Fields

	private Integer id;
	private String text;
	private Short iseffective;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeAnnouncement() {
	}

	/** full constructor */
	public HomeAnnouncement(String text, Short iseffective, Timestamp createdate) {
		this.text = text;
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

	@Column(name = "text")

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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