package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordCollection entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_collection", catalog = "marketcommander")

public class RecordCollection implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userid;
	private Long itemid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordCollection() {
	}

	/** full constructor */
	public RecordCollection(Long userid, Long itemid, Timestamp createdate) {
		this.userid = userid;
		this.itemid = itemid;
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

	@Column(name = "userid")

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "itemid")

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}