package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordChatRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_chat_record", catalog = "marketcommander")

public class RecordChatRecord implements java.io.Serializable {

	// Fields

	private Long id;
	private Long getid;
	private Boolean isassistantsend;
	private Long sendid;
	private String text;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordChatRecord() {
	}

	/** full constructor */
	public RecordChatRecord(Long getid, Boolean isassistantsend, Long sendid, String text, Timestamp createdate) {
		this.getid = getid;
		this.isassistantsend = isassistantsend;
		this.sendid = sendid;
		this.text = text;
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

	@Column(name = "getid")

	public Long getGetid() {
		return this.getid;
	}

	public void setGetid(Long getid) {
		this.getid = getid;
	}

	@Column(name = "isassistantsend")

	public Boolean getIsassistantsend() {
		return this.isassistantsend;
	}

	public void setIsassistantsend(Boolean isassistantsend) {
		this.isassistantsend = isassistantsend;
	}

	@Column(name = "sendid")

	public Long getSendid() {
		return this.sendid;
	}

	public void setSendid(Long sendid) {
		this.sendid = sendid;
	}

	@Column(name = "text")

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
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