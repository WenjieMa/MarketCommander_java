package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_role", catalog = "marketcommander")

public class InfoRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rolecode;
	private String name;
	private String roletree;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoRole() {
	}

	/** full constructor */
	public InfoRole(String rolecode, String name, String roletree, Timestamp createdate, Timestamp updatedate) {
		this.rolecode = rolecode;
		this.name = name;
		this.roletree = roletree;
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

	@Column(name = "rolecode")

	public String getRolecode() {
		return this.rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "roletree")

	public String getRoletree() {
		return this.roletree;
	}

	public void setRoletree(String roletree) {
		this.roletree = roletree;
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