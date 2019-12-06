package nl.willemhustinx.carlease.carservice.controller;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class CarDTO {

    @Id
    @GeneratedValue()

    private String make;
    private String model;
    private String version;
    private String doors;
    private String gross_price;
    private String nett_price;
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

    public String getGross_price() {
        return gross_price;
    }

    public void setGross_price(String gross_price) {
        this.gross_price = gross_price;
    }

    public String getNett_price() {
        return nett_price;
    }

    public void setNett_price(String nett_price) {
        this.nett_price = nett_price;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
}
