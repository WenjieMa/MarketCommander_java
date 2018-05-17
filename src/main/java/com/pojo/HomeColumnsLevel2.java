package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * HomeColumnsLevel2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "home_columns_level2", catalog = "marketcommander")

public class HomeColumnsLevel2 implements java.io.Serializable {

	// Fields

	private Long id;
	private String text;
	private Long parentid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeColumnsLevel2() {
	}

	/** full constructor */
	public HomeColumnsLevel2(String text, Long parentid,Timestamp createdate) {
		this.text = text;
		this.parentid = parentid;
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

	@Column(name = "text")

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "parentid")

	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}