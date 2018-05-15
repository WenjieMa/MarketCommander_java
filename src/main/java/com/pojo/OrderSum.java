package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * OrderSum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_sum", catalog = "marketcommander")

public class OrderSum implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer userid;
	private String type;
	private Double totalprice;
	private Integer provinceid;
	private Integer cityid;
	private Integer countyid;
	private String address;
	private Integer expressid;
	private Integer deliveryid;
	private Integer servicestar;
	private Integer deliverystar;
	private Integer couponid;
	private Integer refundid;
	private Boolean issended;
	private Boolean isreceived;
	private Boolean isdiscard;
	private Timestamp createdate;

	// Constructors

	/** default constructor */
	public OrderSum() {
	}

	/** minimal constructor */
	public OrderSum(Integer userid) {
		this.userid = userid;
	}

	/** full constructor */
	public OrderSum(String name, Integer userid, String type, Double totalprice, Integer provinceid, Integer cityid,
			Integer countyid, String address, Integer expressid, Integer deliveryid, Integer servicestar,
			Integer deliverystar, Integer couponid, Integer refundid, Boolean issended, Boolean isreceived,
			Boolean isdiscard, Timestamp createdate) {
		this.name = name;
		this.userid = userid;
		this.type = type;
		this.totalprice = totalprice;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.countyid = countyid;
		this.address = address;
		this.expressid = expressid;
		this.deliveryid = deliveryid;
		this.servicestar = servicestar;
		this.deliverystar = deliverystar;
		this.couponid = couponid;
		this.refundid = refundid;
		this.issended = issended;
		this.isreceived = isreceived;
		this.isdiscard = isdiscard;
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

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "userid", nullable = false)

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "type")

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "totalprice", precision = 10)

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	@Column(name = "provinceid")

	public Integer getProvinceid() {
		return this.provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	@Column(name = "cityid")

	public Integer getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	@Column(name = "countyid")

	public Integer getCountyid() {
		return this.countyid;
	}

	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}

	@Column(name = "address")

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "expressid")

	public Integer getExpressid() {
		return this.expressid;
	}

	public void setExpressid(Integer expressid) {
		this.expressid = expressid;
	}

	@Column(name = "deliveryid")

	public Integer getDeliveryid() {
		return this.deliveryid;
	}

	public void setDeliveryid(Integer deliveryid) {
		this.deliveryid = deliveryid;
	}

	@Column(name = "servicestar")

	public Integer getServicestar() {
		return this.servicestar;
	}

	public void setServicestar(Integer servicestar) {
		this.servicestar = servicestar;
	}

	@Column(name = "deliverystar")

	public Integer getDeliverystar() {
		return this.deliverystar;
	}

	public void setDeliverystar(Integer deliverystar) {
		this.deliverystar = deliverystar;
	}

	@Column(name = "couponid")

	public Integer getCouponid() {
		return this.couponid;
	}

	public void setCouponid(Integer couponid) {
		this.couponid = couponid;
	}

	@Column(name = "refundid")

	public Integer getRefundid() {
		return this.refundid;
	}

	public void setRefundid(Integer refundid) {
		this.refundid = refundid;
	}

	@Column(name = "issended")

	public Boolean getIssended() {
		return this.issended;
	}

	public void setIssended(Boolean issended) {
		this.issended = issended;
	}

	@Column(name = "isreceived")

	public Boolean getIsreceived() {
		return this.isreceived;
	}

	public void setIsreceived(Boolean isreceived) {
		this.isreceived = isreceived;
	}

	@Column(name = "isdiscard")

	public Boolean getIsdiscard() {
		return this.isdiscard;
	}

	public void setIsdiscard(Boolean isdiscard) {
		this.isdiscard = isdiscard;
	}

	@Column(name = "createdate", length = 19)

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

}