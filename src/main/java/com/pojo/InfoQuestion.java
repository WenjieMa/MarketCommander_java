package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InfoQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_question", catalog = "marketcommander")

public class InfoQuestion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String questiontext;
	private Timestamp createdate;
	private Timestamp updatedate;

	// Constructors

	/** default constructor */
	public InfoQuestion() {
	}

	/** full constructor */
	public InfoQuestion(String questiontext, Timestamp createdate, Timestamp updatedate) {
		this.questiontext = questiontext;
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

	@Column(name = "questiontext")

	public String getQuestiontext() {
		return this.questiontext;
	}

	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
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