package com.supinfo.supsale.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(unique = false, nullable = true)
    private String imageUrl;

    @Column
    @Type(type = "timestamp")
    private Date publishDate;

    @Column
    private Categorie categorie;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_fk")
    private User owner;

    public Advert() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
