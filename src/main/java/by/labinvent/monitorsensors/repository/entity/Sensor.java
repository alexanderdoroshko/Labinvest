package by.labinvent.monitorsensors.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity{


    @Column(name="name")
    @NotEmpty(message = "Name must not be empty")
    @Size(max = 30, message = "Field name cannot contain more than 30 characters ")
    private String name;

    @Column(name="model")
    @NotEmpty(message = "Model must not be empty")
    @Size(max = 15, message = "Field model cannot contain more than 15 characters ")
    private String model;

    @Column(name="RANGE_FROM")
    private int rangeFrom;

    @Column(name="RANGE_TO")
    private int rangeTo;

    @Column(name="type")
    private String type;

    @Column(name="unit")
    private  String unit;

    @Column(name = "location")
    @Size(max = 40, message = "Field location cannot contain more than 40 characters ")
    private String location;

    @Column(name = "description")
    @Size(max = 200, message = "Field description cannot contain more than 30 characters ")
    private String description;

    public Sensor() {
    }

    public Sensor(String name, String model, int rangeFrom, int rangeTo, String type, String unit, String location, String description) {
        this.name = name;
        this.model = model;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.type = type;
        this.unit = unit;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(int rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(int rangeTo) {
        this.rangeTo = rangeTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", rangeFrom=" + rangeFrom +
                ", rangeTo=" + rangeTo +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
