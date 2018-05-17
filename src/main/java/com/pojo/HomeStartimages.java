package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * HomeStartimages entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "home_startimages", catalog = "marketcommander")

public class HomeStartimages implements java.io.Serializable {

	// Fields

	private Long id;
	private String src;
	private String link;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeStartimages() {
	}

	/** full constructor */
	public HomeStartimages(String src, String link, Timestamp createdate) {
		this.src = src;
		this.link = link;
		this.createdate = createdate;
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

	@Column(name = "src")

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Column(name = "link", length = 11)

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}