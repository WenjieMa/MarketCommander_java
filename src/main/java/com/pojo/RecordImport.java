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

	private Long id;
	private Long itemid;
	private Long amount;
	private Double imprice;
	private String supplier;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public RecordImport() {
	}

	/** full constructor */
	public RecordImport(Long itemid, Long amount, Double imprice, String supplier,Timestamp createdate) {
		this.itemid = itemid;
		this.amount = amount;
		this.imprice = imprice;
		this.supplier = supplier;
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

	@Column(name = "itemid")

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	@Column(name = "amount")

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
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

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}