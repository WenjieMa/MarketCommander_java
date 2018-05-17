package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * HomeColumnsLevel1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "home_columns_level1", catalog = "marketcommander")

public class HomeColumnsLevel1 implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String headname;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public HomeColumnsLevel1() {
	}

	/** full constructor */
	public HomeColumnsLevel1(String name, String headname,Timestamp createdate) {
		this.name = name;
		this.headname = headname;
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

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "headname")

	public String getHeadname() {
		return this.headname;
	}

	public void setHeadname(String headname) {
		this.headname = headname;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}