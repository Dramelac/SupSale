package com.supinfo.supsale.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String username;

    @Column(unique=false)
    private String password;

    @Column(unique=false)
    private String firstname;

    @Column(unique=false)
    private String lastname;

    @Column(unique=true)
    private String email;

    @Column(unique=false)
    private String address;

    @Column(unique=false)
    private String phonenumber;

    @Column(unique=false)
    private boolean isAdmin;

    @OneToMany(mappedBy="owner",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Advert> adverts;

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, String email, String address, String phonenumber, boolean isAdmin, List<Advert> adverts) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.isAdmin = isAdmin;
        this.adverts = adverts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean getIsAdmin() {return isAdmin;}

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Advert> getAdverts() {return adverts;}

    public void setAdverts(List<Advert> adverts) {this.adverts = adverts;}

}
