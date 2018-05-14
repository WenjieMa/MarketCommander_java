package com.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by xiaoma on 2018/5/14.
 */

@Entity
@Table(name = "info_user")
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
