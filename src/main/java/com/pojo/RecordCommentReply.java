package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordCommentReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_comment_reply", catalog = "marketcommander")

public class RecordCommentReply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer assistantid;
	private Integer text;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordCommentReply() {
	}

	/** full constructor */
	public RecordCommentReply(Integer assistantid, Integer text, Timestamp createdate) {
		this.assistantid = assistantid;
		this.text = text;
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

	@Column(name = "assistantid")

	public Integer getAssistantid() {
		return this.assistantid;
	}

	public void setAssistantid(Integer assistantid) {
		this.assistantid = assistantid;
	}

	@Column(name = "text")

	public Integer getText() {
		return this.text;
	}

	public void setText(Integer text) {
		this.text = text;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}