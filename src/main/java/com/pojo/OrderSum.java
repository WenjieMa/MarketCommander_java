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
    private Long userid;
    private String type;
    private Double totalprice;
    private String address;
    private String phone;
    private Long deliveryid;
    private Long count;
    private Long state;
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
    public OrderSum(Long userid, String type, Double totalprice,
                    String address, Long deliveryid,
                    Long count, Long state, Timestamp createdate, String phone) {
        this.userid = userid;
        this.type = type;
        this.totalprice = totalprice;
        this.address = address;
        this.deliveryid = deliveryid;
        this.count = count;
        this.state = state;
        this.createdate = createdate;
        this.phone = phone;
    }

    // Property accessors
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator",strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Column(name = "phone")

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Column(name = "count")

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {

        this.count = count;
    }

    @Column(name = "state")

    public Long getState() {
        return this.state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    @Column(name = "createdate", length = 19)

    public Timestamp getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

}