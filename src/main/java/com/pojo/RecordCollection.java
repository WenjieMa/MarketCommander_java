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

	private Integer id;
	private Integer userid;
	private Integer itemid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordCollection() {
	}

	/** full constructor */
	public RecordCollection(Integer userid, Integer itemid, Timestamp createdate) {
		this.userid = userid;
		this.itemid = itemid;
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

	@Column(name = "userid")

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "itemid")

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
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