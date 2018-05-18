package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * InfoUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info_user", catalog = "marketcommander")

public class InfoUser implements java.io.Serializable {

    // Fields

    private Long id;
    private String username;
    private String password;
    private Boolean gender;
    private String headpic;
    private String phone;
    private String email;
    private String nickname;
    private String name;
    private Timestamp createdate;
    private Timestamp updatedate;

    // Constructors

    /**
     * default constructor
     */
    public InfoUser() {
    }

    /**
     * minimal constructor
     */
    public InfoUser(String username, String password, Timestamp createdate) {
        this.username = username;
        this.password = password;
        this.createdate = createdate;
    }

    /**
     * full constructor
     */
    public InfoUser(String username, String password, Boolean gender, String headpic,
                    String phone, String email, String nickname, String name, Timestamp createdate, Timestamp updatedate) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.headpic = headpic;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.createdate = createdate;
        this.updatedate = updatedate;
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

    @Column(name = "username", nullable = false)

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "gender")

    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Column(name = "headpic")

    public String getHeadpic() {
        return this.headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    @Column(name = "phone")

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "nickname")

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "name")

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "createdate", nullable = false, length = 19)

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