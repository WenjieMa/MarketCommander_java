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

	private Long id;
	private Long sumid;
	private Long itemid;
	private Long quantity;
	private Double itemstar;
	private Long commentid;
	private Long addcommentid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public OrderSmall() {
	}

	/** minimal constructor */
	public OrderSmall(Long sumid, Long itemid) {
		this.sumid = sumid;
		this.itemid = itemid;
	}

	/** full constructor */
	public OrderSmall(Long sumid, Long itemid, Long quantity, Double itemstar, Long commentid,
			Long addcommentid, Timestamp createdate) {
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "sumid", nullable = false)

	public Long getSumid() {
		return this.sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}

	@Column(name = "itemid", nullable = false)

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	@Column(name = "quantity")

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Column(name = "itemstar")

	public Double getItemstar() {
		return this.itemstar;
	}

	public void setItemstar(Double itemstar) {
		this.itemstar = itemstar;
	}

	@Column(name = "commentid")

	public Long getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	@Column(name = "addcommentid")

	public Long getAddcommentid() {
		return this.addcommentid;
	}

	public void setAddcommentid(Long addcommentid) {
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