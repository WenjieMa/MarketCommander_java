package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * RecordImport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "record_import", catalog = "marketcommander")

public class RecordImport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer itemid;
	private String amount;
	private Double imprice;
	private String supplier;
	private Boolean ischecked;
	private Timestamp checktime;
	private Integer operatorid;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordImport() {
	}

	/** full constructor */
	public RecordImport(Integer itemid, String amount, Double imprice, String supplier, Boolean ischecked,
			Timestamp checktime, Integer operatorid, Timestamp createdate) {
		this.itemid = itemid;
		this.amount = amount;
		this.imprice = imprice;
		this.supplier = supplier;
		this.ischecked = ischecked;
		this.checktime = checktime;
		this.operatorid = operatorid;
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

	@Column(name = "itemid")

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	@Column(name = "amount")

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "imprice", precision = 10)

	public Double getImprice() {
		return this.imprice;
	}

	public void setImprice(Double imprice) {
		this.imprice = imprice;
	}

	@Column(name = "supplier")

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Column(name = "ischecked")

	public Boolean getIschecked() {
		return this.ischecked;
	}

	public void setIschecked(Boolean ischecked) {
		this.ischecked = ischecked;
	}

	@Column(name = "checktime", length = 19)

	public Timestamp getChecktime() {
		return this.checktime;
	}

	public void setChecktime(Timestamp checktime) {
		this.checktime = checktime;
	}

	@Column(name = "operatorid")

	public Integer getOperatorid() {
		return this.operatorid;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}