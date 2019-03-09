package vw.test.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;


    private float averageCOConcentration;

    private float averageSensorResponseCO;

    private float averageNonMetanicHydroCarbons;
    private float averageBenzeneConcentration;
    private float averageSensorResponseNMHC;

    private float averageNOXConcentration;
    private float averageSensorResponseNOX;

    private float averageNO2Concentration;
    private float averageSensorResponseNO2;

    private float averageSensorResponseO3;

    private float temperature;
    private float relativeHumidity;
    private float absoluteHumidity;

    public Measure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public float getAverageCOConcentration() {
        return averageCOConcentration;
    }

    public void setAverageCOConcentration(float averageCOConcentration) {
        this.averageCOConcentration = averageCOConcentration;
    }

    public float getAverageSensorResponseCO() {
        return averageSensorResponseCO;
    }

    public void setAverageSensorResponseCO(float averageSensorResponseCO) {
        this.averageSensorResponseCO = averageSensorResponseCO;
    }

    public float getAverageNonMetanicHydroCarbons() {
        return averageNonMetanicHydroCarbons;
    }

    public void setAverageNonMetanicHydroCarbons(float averageNonMetanicHydroCarbons) {
        this.averageNonMetanicHydroCarbons = averageNonMetanicHydroCarbons;
    }

    public float getAverageBenzeneConcentration() {
        return averageBenzeneConcentration;
    }

    public void setAverageBenzeneConcentration(float averageBenzeneConcentration) {
        this.averageBenzeneConcentration = averageBenzeneConcentration;
    }

    public float getAverageSensorResponseNMHC() {
        return averageSensorResponseNMHC;
    }

    public void setAverageSensorResponseNMHC(float averageSensorResponseNMHC) {
        this.averageSensorResponseNMHC = averageSensorResponseNMHC;
    }

    public float getAverageNOXConcentration() {
        return averageNOXConcentration;
    }

    public void setAverageNOXConcentration(float averageNOXConcentration) {
        this.averageNOXConcentration = averageNOXConcentration;
    }

    public float getAverageSensorResponseNOX() {
        return averageSensorResponseNOX;
    }

    public void setAverageSensorResponseNOX(float averageSensorResponseNOX) {
        this.averageSensorResponseNOX = averageSensorResponseNOX;
    }

    public float getAverageNO2Concentration() {
        return averageNO2Concentration;
    }

    public void setAverageNO2Concentration(float averageNO2Concentration) {
        this.averageNO2Concentration = averageNO2Concentration;
    }

    public float getAverageSensorResponseNO2() {
        return averageSensorResponseNO2;
    }

    public void setAverageSensorResponseNO2(float averageSensorResponseNO2) {
        this.averageSensorResponseNO2 = averageSensorResponseNO2;
    }

    public float getAverageSensorResponseO3() {
        return averageSensorResponseO3;
    }

    public void setAverageSensorResponseO3(float averageSensorResponseO3) {
        this.averageSensorResponseO3 = averageSensorResponseO3;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(float relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public float getAbsoluteHumidity() {
        return absoluteHumidity;
    }

    public void setAbsoluteHumidity(float absoluteHumidity) {
        this.absoluteHumidity = absoluteHumidity;
    }
}