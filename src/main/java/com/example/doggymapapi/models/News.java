package com.example.doggymapapi.models;

import jakarta.persistence.*;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long news_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "banner_title")
    private String banner_title;

    @Column(name = "artwork")
    private String artwork;

    @Column(name = "text")
    private String text;

    @Column(name = "link")
    private String link;

    // Геттеры и сеттеры



    public News(){}
    public News(Long news_id, String name, String description, String banner_title, String artwork, String text, String link) {
        this.news_id = news_id;
        this.name = name;
        this.description = description;
        this.banner_title = banner_title;
        this.artwork = artwork;
        this.text = text;
        this.link = link;
    }

    public Long getNewsID() {
        return news_id;
    }

    public void setNewsID(Long news_id) {
        this.news_id = news_id;
    }


    public String getNewsName() {
        return name;
    }

    public void setNewsName(String name) {
        this.name = name;
    }


    public String getNewsDescription() {
        return description;
    }

    public void setNewsDescription(String description) {
        this.description = description;
    }


    public String getNewsBannerTitle() { return banner_title;}

    public void setNewsBannerTitle(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getNewsArtwork() { return artwork; }

    public void setNewsArtwork(String artwork) {
        this.artwork = artwork;
    }


    public String getNewsText() { return text; }

    public void setNewsText(String text) {
        this.text = text;
    }

    public String getNewsLink() { return link; }

    public void setNewsLink(String link) {
        this.link = link;
    }

}

