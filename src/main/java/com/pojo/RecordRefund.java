package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordRefund entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_refund", catalog = "marketcommander")

public class RecordRefund implements java.io.Serializable {

	// Fields

	private Long id;
	private Long priorderid;
	private Long neworderid;
	private String reason;
	private Boolean ischecked;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordRefund() {
	}

	/** full constructor */
	public RecordRefund(Long priorderid, Long neworderid, String reason, Boolean ischecked, Timestamp createdate) {
		this.priorderid = priorderid;
		this.neworderid = neworderid;
		this.reason = reason;
		this.ischecked = ischecked;
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

	@Column(name = "priorderid")

	public Long getPriorderid() {
		return this.priorderid;
	}

	public void setPriorderid(Long priorderid) {
		this.priorderid = priorderid;
	}

	@Column(name = "neworderid")

	public Long getNeworderid() {
		return this.neworderid;
	}

	public void setNeworderid(Long neworderid) {
		this.neworderid = neworderid;
	}

	@Column(name = "reason")

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "ischecked")

	public Boolean getIschecked() {
		return this.ischecked;
	}

	public void setIschecked(Boolean ischecked) {
		this.ischecked = ischecked;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}