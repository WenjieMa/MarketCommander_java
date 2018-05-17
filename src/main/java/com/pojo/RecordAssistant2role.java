package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordAssistant2role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_assistant2role", catalog = "marketcommander")

public class RecordAssistant2role implements java.io.Serializable {

	// Fields

	private Long id;
	private Long assistantid;
	private Long roleid;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public RecordAssistant2role() {
	}

	/** full constructor */
	public RecordAssistant2role(Long assistantid,Long roleid,Timestamp createdate, Timestamp updatedate) {
		this.assistantid = assistantid;
		this.roleid = roleid;
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

	@Column(name = "assistantid")

	public Long getAssistantid() {
		return this.assistantid;
	}

	public void setAssistantid(Long assistantid) {
		this.assistantid = assistantid;
	}

	@Column(name = "roleid")

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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