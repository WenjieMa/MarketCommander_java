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

    private Long id;
    private String name;
    private Long userid;
    private String type;
    private Double totalprice;
    private String address;
    private Long deliveryid;
    private Long servicestar;
    private Long deliverystar;
    private Long couponid;
    private Boolean issended;
    private Boolean isreceived;
    private Boolean isdiscard;
    private Timestamp createdate;

    // Constructors

    /**
     * default constructor
     */
    public OrderSum() {
    }

    /**
     * minimal constructor
     */
    public OrderSum(Long userid) {
        this.userid = userid;
    }

    /**
     * full constructor
     */
    public OrderSum(String name, Long userid, String type, Double totalprice,
                    String address, Long deliveryid, Long servicestar,
                    Long deliverystar, Long couponid, Boolean issended, Boolean isreceived,
                    Boolean isdiscard, Timestamp createdate) {
        this.name = name;
        this.userid = userid;
        this.type = type;
        this.totalprice = totalprice;
        this.address = address;
        this.deliveryid = deliveryid;
        this.servicestar = servicestar;
        this.deliverystar = deliverystar;
        this.couponid = couponid;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
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

    @Column(name = "address")

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "deliveryid")

    public Long getDeliveryid() {
        return this.deliveryid;
    }

    public void setDeliveryid(Long deliveryid) {
        this.deliveryid = deliveryid;
    }

    @Column(name = "servicestar")

    public Long getServicestar() {
        return this.servicestar;
    }

    public void setServicestar(Long servicestar) {
        this.servicestar = servicestar;
    }

    @Column(name = "deliverystar")

    public Long getDeliverystar() {
        return this.deliverystar;
    }

    public void setDeliverystar(Long deliverystar) {
        this.deliverystar = deliverystar;
    }

    @Column(name = "couponid")

    public Long getCouponid() {
        return this.couponid;
    }

    public void setCouponid(Long couponid) {
        this.couponid = couponid;
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