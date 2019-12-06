package nl.willemhustinx.carlease.carservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Car {

     @Id
     @GeneratedValue(strategy = IDENTITY)
    private long carID;

    private String make;
    private String model;
    private String version;
    private String doors;
    private String gross_price;
    private String nett_price;
    private String hp;

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

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
