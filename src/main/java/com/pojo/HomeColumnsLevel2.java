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

	private Integer id;
	private String text;
	private Integer parentid;
	private Boolean ishead;
	private Integer index;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeColumnsLevel2() {
	}

	/** full constructor */
	public HomeColumnsLevel2(String text, Integer parentid, Boolean ishead, Integer index, Timestamp createdate) {
		this.text = text;
		this.parentid = parentid;
		this.ishead = ishead;
		this.index = index;
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

	@Column(name = "parentid")

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "ishead")

	public Boolean getIshead() {
		return this.ishead;
	}

	public void setIshead(Boolean ishead) {
		this.ishead = ishead;
	}

	@Column(name = "index")

	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}