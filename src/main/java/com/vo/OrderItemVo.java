package com.vo;

import com.pojo.InfoItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

public class OrderItemVo {

    // Fields

    private Long id;
    private Long typeid;
    private String name;
    private Double price;
    private Boolean iseffective;
    private Long likes;
    private Long store;
    private Boolean isoff;
    private Float discount;
    private String textbig;
    private String textsmall;
    private String description;
    private String itempic;

    // Constructors

    /**
     * default constructor
     */
    public OrderItemVo() {
    }

    /**
     * full constructor
     */
    public OrderItemVo(InfoItem infoItem) {
        this.typeid = infoItem.getTypeid();
        this.name = infoItem.getName();
        this.price = infoItem.getPrice();
        this.iseffective = infoItem.getIseffective();
        this.likes = infoItem.getLikes();
        this.store = infoItem.getStore();
        this.isoff = infoItem.getIsoff();
        this.discount = infoItem.getDiscount();
        this.textbig = infoItem.getTextbig();
        this.textsmall = infoItem.getTextsmall();
        this.description = infoItem.getDescription();
        this.itempic = infoItem.getItempic();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeid() {
        return this.typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIseffective() {
        return this.iseffective;
    }

    public void setIseffective(Boolean iseffective) {
        this.iseffective = iseffective;
    }

    public Long getLikes() {
        return this.likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getStore() {
        return this.store;
    }

    public void setStore(Long store) {
        this.store = store;
    }

    public Boolean getIsoff() {
        return this.isoff;
    }

    public void setIsoff(Boolean isoff) {
        this.isoff = isoff;
    }

    public Float getDiscount() {
        return this.discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getTextbig() {
        return this.textbig;
    }

    public void setTextbig(String textbig) {
        this.textbig = textbig;
    }

    public String getItempic() {
        return this.itempic;
    }

    public void setItempic(String itempic) {
        this.itempic = itempic;
    }

    public String getTextsmall() {
        return this.textsmall;
    }

    public void setTextsmall(String textsmall) {
        this.textsmall = textsmall;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}