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

	private Integer id;
	private Integer getid;
	private Short isassistantsend;
	private Integer sendid;
	private String text;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordChatRecord() {
	}

	/** full constructor */
	public RecordChatRecord(Integer getid, Short isassistantsend, Integer sendid, String text, Timestamp createdate) {
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

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "getid")

	public Integer getGetid() {
		return this.getid;
	}

	public void setGetid(Integer getid) {
		this.getid = getid;
	}

	@Column(name = "isassistantsend")

	public Short getIsassistantsend() {
		return this.isassistantsend;
	}

	public void setIsassistantsend(Short isassistantsend) {
		this.isassistantsend = isassistantsend;
	}

	@Column(name = "sendid")

	public Integer getSendid() {
		return this.sendid;
	}

	public void setSendid(Integer sendid) {
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