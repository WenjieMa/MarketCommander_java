package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_comment", catalog = "marketcommander")

public class RecordComment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private Integer replyid;
	private Integer itemid;
	private String comment;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordComment() {
	}

	/** full constructor */
	public RecordComment(Integer userid, Integer replyid, Integer itemid, String comment, Timestamp createdate) {
		this.userid = userid;
		this.replyid = replyid;
		this.itemid = itemid;
		this.comment = comment;
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

	@Column(name = "replyid")

	public Integer getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	@Column(name = "itemid")

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	@Column(name = "comment")

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}