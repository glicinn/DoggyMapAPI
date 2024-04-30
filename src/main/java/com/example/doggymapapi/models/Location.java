package com.example.doggymapapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long location_id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "city_name", nullable = false)
    private String city_name;

    @Column(name = "x_coordinate", nullable = false)
    private Double x_coordinate;

    @Column(name = "y_coordinate", nullable = false)
    private Double y_coordinate;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "link", nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT 'https://thecity.m24.ru/articles/7583'")
    private String link;

    // Геттеры и сеттеры

    public Location() {}

    public Location(Long location_id, String name, String city_name, Double x_coordinate, Double y_coordinate, String description, String link) {
        this.location_id = location_id;
        this.name = name;
        this.city_name = city_name;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.description = description;
        this.link = link;
    }

    public Long getLocationID() {
        return location_id;
    }

    public void setLocationID(Long location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String city_name) {
        this.city_name = city_name;
    }

    public Double getXCoordinate() {
        return x_coordinate;
    }

    public void setXCoordinate(Double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public Double getYCoordinate() {
        return y_coordinate;
    }

    public void setYCoordinate(Double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}