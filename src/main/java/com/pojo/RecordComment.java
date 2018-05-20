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

	private Long id;
	private Long userid;
	private Long replyid;
	private Long itemid;
	private String comment;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordComment() {
	}

	/** full constructor */
	public RecordComment(Long userid, Long replyid, Long itemid, String comment, Timestamp createdate) {
		this.userid = userid;
		this.replyid = replyid;
		this.itemid = itemid;
		this.comment = comment;
		this.createdate = createdate;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator",strategy = GenerationType.IDENTITY)

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

	@Column(name = "replyid")

	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	@Column(name = "itemid")

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
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