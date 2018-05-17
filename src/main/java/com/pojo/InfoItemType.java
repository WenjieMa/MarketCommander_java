package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoItemType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_item_type", catalog = "marketcommander")

public class InfoItemType implements java.io.Serializable {

	// Fields

	private Long id;
	private String typename;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public InfoItemType() {
	}

	/** full constructor */
	public InfoItemType(String typename, Timestamp createdate) {
		this.typename = typename;
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

	@Column(name = "typename")

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}