package com.supinfo.supsale.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Advert implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = false)
    private String name;

    @Column(unique = false)
    private String description;

    @Column(unique = false)
    private int price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_fk")
    private User owner;

    public Advert() {
    }

    public Advert(String name, String description, int price, User user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.owner = user;
    }

    public int getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    public User getOwner() {return owner;}

    public void setOwner(User user) {this.owner = user;}
}
