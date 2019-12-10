package nl.willemhustinx.carlease.carservice.controller;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CarDTO {

    @Id
    @GeneratedValue()

    private String make;
    private String model;
    private String version;
    private String doors;
    private String grossPrice;
    private String nettPrice;
    private String hp;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(String grossPrice) {
        this.grossPrice = grossPrice;
    }

    public String getNettPrice() {
        return nettPrice;
    }

    public void setNettPrice(String nettPrice) {
        this.nettPrice = nettPrice;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
