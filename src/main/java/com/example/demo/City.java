package com.example.demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "CITY")
@Entity
public class City {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "state")
    private String state;

    @Version
    @Column(name = "version")
    private int version;

    public City(String cityName, String state) {
        this.cityName = cityName;
        this.state = state;
    }

    public City() {
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
