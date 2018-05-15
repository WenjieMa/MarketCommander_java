package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * OrderSmall entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_small", catalog = "marketcommander")

public class OrderSmall implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sumid;
	private Integer itemid;
	private Integer quantity;
	private Integer itemstar;
	private Integer commentid;
	private Integer addcommentid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public OrderSmall() {
	}

	/** minimal constructor */
	public OrderSmall(Integer sumid, Integer itemid) {
		this.sumid = sumid;
		this.itemid = itemid;
	}

	/** full constructor */
	public OrderSmall(Integer sumid, Integer itemid, Integer quantity, Integer itemstar, Integer commentid,
			Integer addcommentid, Timestamp createdate) {
		this.sumid = sumid;
		this.itemid = itemid;
		this.quantity = quantity;
		this.itemstar = itemstar;
		this.commentid = commentid;
		this.addcommentid = addcommentid;
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

	@Column(name = "sumid", nullable = false)

	public Integer getSumid() {
		return this.sumid;
	}

	public void setSumid(Integer sumid) {
		this.sumid = sumid;
	}

	@Column(name = "itemid", nullable = false)

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	@Column(name = "quantity")

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "itemstar")

	public Integer getItemstar() {
		return this.itemstar;
	}

	public void setItemstar(Integer itemstar) {
		this.itemstar = itemstar;
	}

	@Column(name = "commentid")

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	@Column(name = "addcommentid")

	public Integer getAddcommentid() {
		return this.addcommentid;
	}

	public void setAddcommentid(Integer addcommentid) {
		this.addcommentid = addcommentid;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}